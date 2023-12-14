package com.neel.hrms.payroll.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.neel.hrms.payroll.bean.EmployeeCTCAccessBean;
import com.neel.hrms.payroll.bean.PayrollAccessBean;
import com.neel.hrms.payroll.repository.EmployeeCTCRepository;
import com.neel.hrms.payroll.repository.PayrollRepository;
import com.neel.hrms.payroll.utils.LeaveAndHolidayAndSundayCalculator;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalaryCalculatorServiceImpl implements SalaryCalculatorService{
	
	java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private final EmployeeCTCRepository employeeCTCRepository;
	
	private final PayrollRepository payrollRepository;
	
	/**
	 * 
	 * @param startDay
	 * @param endDay
	 * @param totalDay
	 * @param hoursWorked
	 * @param gross pay -> salary fetch from employeeCTC table
	 * @param deduction -> month's day - total Day
	 * @param netPay -> present day salary
	 * @param accountId
	 * @param employeeId -> Generate by system at time of joining
	 * 
	 * */
	@Override
	public List<PayrollAccessBean> calculateSalary(MultipartFile csv) {
		
		List<PayrollAccessBean> payrollList =  new ArrayList<>();
		
		//Get One by One data from CSV 
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(new ByteArrayInputStream(csv.getBytes()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		BufferedReader csvReader = new BufferedReader(isr);
		String line = "";
		int count = 0;
		try {
			while (( line = csvReader.readLine()) != null) {
				if(count >= 1) {
					String[] data = line.split(",");
						//convert into payroll
						PayrollAccessBean payrollAccessBean = savePayroll(data);
						payrollList.add(payrollAccessBean);
						
					}
				count++;
				}
				
			return payrollList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	private PayrollAccessBean savePayroll(String[] data) {
		PayrollAccessBean payrollAccessBean = new PayrollAccessBean();
		payrollAccessBean.setAccountId(null);
		payrollAccessBean.setEmployeeId(data[1]);
		payrollAccessBean.setStartDay(LocalDate.parse(data[2], formatter));
		payrollAccessBean.setEndDay(LocalDate.parse(data[3], formatter));
		payrollAccessBean.setTotalDay(Long.parseLong(data[4]));
		payrollAccessBean.setHoursWorked(Long.parseLong(data[5]));
		payrollAccessBean.setGrossPay(Long.parseLong(data[6]));
		payrollAccessBean.setDeduction(Long.parseLong(data[7]));
		payrollAccessBean.setNetPay(Long.parseLong(data[8]));
		
		payrollRepository.save(payrollAccessBean);
		return payrollAccessBean;
	}

	@Override
	public String calculateAutoSalary(MultipartFile csv,HttpServletRequest request) {
		
		//Get One by One data from CSV 
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(new ByteArrayInputStream(csv.getBytes()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		BufferedReader csvReader = new BufferedReader(isr);
		String line = "";
		int count = 0;
		String flag = "Failed"; //Used for create error file
		//Error Object
		StringBuilder errors = new StringBuilder("");
		// For Session management
		boolean invalidLine = false;
		
		try {
			while (( line = csvReader.readLine()) != null) {
				if(count >= 1) {
					String[] data = line.split(",");
					//Check duplicate data if true
					boolean processFlag = payrollExistOrNot(data);
					if(!processFlag) {
						//Save and calculate for db
						flag = saveAndCalculateEmployeesPayroll(data,errors);
					}
					else {
						errors.append("Entry already uploaded in DB : " + data[1]);
						invalidLine = true;
					}	
				}
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// creating error files
		if (!flag.equals("Success")) 
		{
			createFailedFileCSV(errors, request, count + 1);
		}

		return flag;
	
	}

	private void createFailedFileCSV(StringBuilder errors, HttpServletRequest request, int i) {
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		arrayOutputStream.write(errors.toString().getBytes());
		request.getSession(invalidLine).setAttribute("csvErrFile", arrayOutputStream);
	}

	private String saveAndCalculateEmployeesPayroll(String[] data, StringBuilder errors) {
		String flag = "Failed";
		//Get employeeCtc data from database
		EmployeeCTCAccessBean employeeCTCAccessBean = employeeCTCRepository.findByEmployeeId(data[1]);
			if(employeeCTCAccessBean != null){
			Long ctc = employeeCTCAccessBean.getCTC() == null ? 0L :employeeCTCAccessBean.getCTC();
			
			float totalDeduction = calculateDeduction(employeeCTCAccessBean,data);
			float netPay = ctc - totalDeduction;
			
			try {
				//convert into payroll
				saveInDB(data,ctc,totalDeduction,netPay);
				flag = "Success";
			}
			catch(Exception e) {
			  errors.append("Something issue when saved in DB " + data[1]);
			}
		}
		else {
			errors.append("Employee Code is not present in DB " + data[1]);
		}
			return flag;
	}

	private PayrollAccessBean saveInDB(String[] data, Long ctc, float totalDeduction, float netPay) {
		PayrollAccessBean payrollAccessBean = new PayrollAccessBean();
		payrollAccessBean.setAccountId(null);
		payrollAccessBean.setEmployeeId(data[1]);
		payrollAccessBean.setStartDay(LocalDate.parse(data[2], formatter));
		payrollAccessBean.setEndDay(LocalDate.parse(data[3], formatter));
		payrollAccessBean.setTotalDay(Long.parseLong(data[4]));
		payrollAccessBean.setHoursWorked(Long.parseLong(data[5]));
		payrollAccessBean.setGrossPay(ctc);
		payrollAccessBean.setDeduction(totalDeduction);
		payrollAccessBean.setNetPay(netPay);
		
		payrollRepository.save(payrollAccessBean);
		
		return payrollAccessBean;
	}

	private boolean payrollExistOrNot(String[] data) {
		return payrollRepository.existsByEmployeeIdAndStartDayAndEndDay(data[1],LocalDate.parse(data[2], formatter), LocalDate.parse(data[3], formatter));
	}


	private long calculateLeaves(String startDate, String endDate, String totalPresentDay, long holidaysAndSundays) {
		return LeaveAndHolidayAndSundayCalculator.calculateLeaves(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter), Long.parseLong(totalPresentDay),holidaysAndSundays);
	}

	private long calculateHolidayAndSunday(String startDate, String endDate) {

		  // int year = 2023; // Replace with the desired year
        // Month month = Month.DECEMBER; // Replace with the desired month

      // List of holidays (add your specific holidays)
      // List<LocalDate> holidays = fetchHolidays(year, month)
      List<LocalDate> holidays = LeaveAndHolidayAndSundayCalculator.fetchHolidays();
      long holidayCount = LeaveAndHolidayAndSundayCalculator.calculateHolidays(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter), holidays);
      long sundayCount  = LeaveAndHolidayAndSundayCalculator.calculateSundays(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter));
      System.out.println(holidayCount+"--"+sundayCount);
      
		return holidayCount + sundayCount;
	}

	private float calculateDeduction(EmployeeCTCAccessBean employeeCTCAccessBean,String[] data) {
		
		// Calculate holidays and Sundays
        long holidaysAndSundays = calculateHolidayAndSunday(data[2],data[3]);
        
        //Calculate working Days
        //Calculate leaves -> days - holiday - working days
        long leaves = calculateLeaves(data[2],data[3],data[4],holidaysAndSundays);
       
        //Calculate per day salary
        float perDaySalary = calculatePerDaySalary(employeeCTCAccessBean.getCTC());
		
		//Calculate deduction -> 
        float leave = leaves * perDaySalary;
        float pf = employeeCTCAccessBean.getPf() == null ? 0L : employeeCTCAccessBean.getPf();
        float esi = employeeCTCAccessBean.getEsi() == null ? 0L : employeeCTCAccessBean.getEsi();
        float tds = employeeCTCAccessBean.getTds() == null ? 0L : employeeCTCAccessBean.getTds();
        float mediclaim = employeeCTCAccessBean.getMediclame() == null ? 0L : employeeCTCAccessBean.getMediclame();
		return pf + esi + tds + mediclaim + leave;
	}

	private float calculatePerDaySalary(Long ctc) {
		return ctc/30f;
	}



}
