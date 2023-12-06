package com.neel.hrms.payroll.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neel.hrms.payroll.bean.PayrollAccessBean;
import com.neel.hrms.payroll.service.AutoSalaryCalculatorService;
import com.neel.hrms.payroll.utils.CsvUtills;

import lombok.RequiredArgsConstructor;

@RestController("/pay")
@RequiredArgsConstructor
public class EmployeeSalaryCmd {
	
	private final AutoSalaryCalculatorService autoSalaryCalculatorService;
	
	private final CsvUtills csvUtills;
	
	//Bio-metric Salary
	@PostMapping("/bioSal")
	public ResponseEntity<String> payBioSal(
			@RequestParam("csv") MultipartFile csv, 
			@RequestParam("calculationType") boolean flag){
		
		//Check CSV value correct or not
		boolean isCorrect = csvUtills.checkSalaryCsv(csv);
		
		List<PayrollAccessBean> payrollList = new ArrayList<>();
		
		if(flag) {
			payrollList = autoSalaryCalculatorService.calculateSalary(csv);
		}
		
		return null;
		
	}

}
