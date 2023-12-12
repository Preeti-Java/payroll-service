package com.neel.hrms.payroll.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neel.hrms.payroll.service.SalaryCalculatorService;
import com.neel.hrms.payroll.utils.CsvUtills;
import com.neel.hrms.payroll.utils.DownloadUtills;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class EmployeeSalaryCmd {
	
	private final SalaryCalculatorService salaryCalculatorService;
	
	private final CsvUtills csvUtills;
	
	private final DownloadUtills downloadUtills;
	
	
	@GetMapping("/csvHeaderTemp")
	public void downloadCSVHeader(HttpServletResponse response, @RequestParam("BiometricCsvHeader") String param) throws Exception {
		downloadUtills.generateCsvTemplate(param,response);
	}
	
	//Bio-metric Salary
	@PostMapping("/bioSal")
	public ResponseEntity<String> payBioSal(HttpServletRequest request,
			@RequestParam("csv") MultipartFile csv, 
			@RequestParam("calculationType") boolean flag) throws IOException{
		
		//Check CSV value correct or not
		csvUtills.checkSalaryCsv(csv,request);
		if(flag) {
			salaryCalculatorService.calculateAutoSalary(csv);
		}
		else
			salaryCalculatorService.calculateSalary(csv);
		
		return ResponseEntity.ok().body("Success");
		
	}

}
