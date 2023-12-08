package com.neel.hrms.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neel.hrms.payroll.bean.EmployeeCTCAccessBean;

@Transactional
@Repository
public interface EmployeeCTCRepository extends JpaRepository<EmployeeCTCAccessBean, Long> {

	boolean existsByEmployeeId(Long employeeId);

	EmployeeCTCAccessBean findByEmployeeId(String employeeId);

	EmployeeCTCAccessBean findEmployeeCTCByEmployeeCTCId(Long employeeCTCId);

	long deleteByEmployeeId(Long employeeId);

	long deleteByEmployeeCTCId(Long employeeCTCId);
	

}
