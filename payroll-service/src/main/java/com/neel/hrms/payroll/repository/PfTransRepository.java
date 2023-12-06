package com.neel.hrms.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neel.hrms.payroll.bean.PfTransAccessBean;

@Repository
public interface PfTransRepository extends JpaRepository<PfTransAccessBean, Long> {

}
