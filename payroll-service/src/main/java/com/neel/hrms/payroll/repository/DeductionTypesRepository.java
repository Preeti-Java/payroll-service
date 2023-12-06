package com.neel.hrms.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neel.hrms.payroll.bean.DeductionTypesAccessBean;

@Repository
public interface DeductionTypesRepository extends JpaRepository<DeductionTypesAccessBean, Long> {

}
