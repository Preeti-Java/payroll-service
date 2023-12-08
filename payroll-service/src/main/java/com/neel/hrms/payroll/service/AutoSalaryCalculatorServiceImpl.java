package com.neel.hrms.payroll.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.neel.hrms.payroll.bean.EmployeeCTCAccessBean;
import com.neel.hrms.payroll.bean.PayrollAccessBean;
import com.neel.hrms.payroll.repository.EmployeeCTCRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutoSalaryCalculatorServiceImpl implements AutoSalaryCalculatorService{

	private final EmployeeCTCRepository employeeCTCRepository;
	
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
		//Get One by One data from CSV 
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(new ByteArrayInputStream(csv.getBytes()), "UTF8");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		BufferedReader csvReader = new BufferedReader(isr);
		String line = "";
		try {
			while (( line = csvReader.readLine()) != null) {
				String[] data = line.split(",");
				//Get employeeCtc data from database
				EmployeeCTCAccessBean employeeCTCAccessBean = employeeCTCRepository.findByEmployeeId(data[1]);
				Long ctc = employeeCTCAccessBean.getCTC();
				//Calculate deduction -> 
				Long pf = employeeCTCAccessBean.getPf();
				Long esi = employeeCTCAccessBean.getEsi();
				Long tds = employeeCTCAccessBean.getTds();
				Long mediclaim = employeeCTCAccessBean.getMediclame();
				//Leaves Calculate 
				Long leaveDeducation = leaveCalculate(ctc,data);
				Long holidayDeducation = checkDate(stringConvertToCalender(data[2]),stringConvertToCalender(data[3]));
				
				Long totalDeduction = pf + esi + tds + mediclaim;
				
				Long netPay = ctc - totalDeduction;
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	private Calendar stringConvertToCalender(String data) {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
		  Date date = formatter.parse(data);
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(date);
		  return calendar;
		} catch (ParseException e) {
		  e.printStackTrace();
		}
		return null;
	}

	private Long leaveCalculate(Long ctc, String[] data) {
		// Assume every month has 30 day
		Long absentDays = 30 - Long.parseLong(data[4]);
		return absentDays * (ctc / 30);
	}
	
	/**
     * Check if the given dates match on day and month.
     *
     * @param cal
     *            The Calendar representing the first date.
     * @param other
     *            The Calendar representing the second date.
     * @return true if they match, false otherwise.
     */
    private static boolean checkDate(Calendar cal, Calendar other) {
        return checkDate(cal, other.get(Calendar.DATE),
                other.get(Calendar.MONTH));
    }

    
    /**
     * Check if the given date represents the given date and month.
     *
     * @param cal
     *            The Calendar object representing date to check.
     * @param date
     *            The date.
     * @param month
     *            The month.
     * @return true if they match, false otherwise.
     */
    private static boolean checkDate(Calendar cal, int date, int month) {
        return cal.get(Calendar.DATE) == date
                && cal.get(Calendar.MONTH) == month;
    }
}
