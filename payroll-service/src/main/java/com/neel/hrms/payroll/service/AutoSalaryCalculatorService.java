package com.neel.hrms.payroll.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.neel.hrms.payroll.bean.PayrollAccessBean;

public interface AutoSalaryCalculatorService {

	List<PayrollAccessBean> calculateSalary(MultipartFile csv);

}