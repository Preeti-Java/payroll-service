package com.neel.hrms.payroll.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.neel.hrms.payroll.bean.PayrollAccessBean;

import jakarta.servlet.http.HttpServletRequest;

public interface SalaryCalculatorService {

	List<PayrollAccessBean> calculateSalary(MultipartFile csv);

	String calculateAutoSalary(MultipartFile csv, HttpServletRequest request);

}
