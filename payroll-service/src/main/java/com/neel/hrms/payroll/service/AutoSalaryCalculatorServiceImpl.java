package com.neel.hrms.payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.neel.hrms.payroll.bean.PayrollAccessBean;
import com.neel.hrms.payroll.repository.EmployeeCTCRepository;

import lombok.RequiredArgsConstructor;

import java.util.Collections;

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
		//Get employeeCtc data from database
		
		
		return Collections.emptyList();
	}

}
