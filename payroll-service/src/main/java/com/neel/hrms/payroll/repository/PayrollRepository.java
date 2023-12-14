package com.neel.hrms.payroll.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neel.hrms.payroll.bean.PayrollAccessBean;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollAccessBean, Long> {

	boolean existsByEmployeeIdAndStartDayAndEndDay(String employeeId, LocalDate localDate, LocalDate localDate2);

}
