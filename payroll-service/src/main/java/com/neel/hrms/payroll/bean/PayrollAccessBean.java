package com.neel.hrms.payroll.bean;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *	@Author
 *	Preeti Dhiman
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payroll")
public class PayrollAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payrollId")
	private Long payrollId;

	@Column(name = "employeeId")
	private String employeeId;

	@Column(name = "startDay")
	private LocalDate startDay;

	@Column(name = "hoursWorked")
	private Long hoursWorked;

	@Column(name = "grossPay")
	private float grossPay;

	@Column(name = "deduction")
	private float deduction;

	@Column(name = "netPay")
	private float netPay;

	@Column(name = "accountId")
	private Long accountId;
	
	@Column(name = "totalDay")
	private Long totalDay;

	@Column(name = "endDay")
	private LocalDate endDay;

	@Column(name = "col2")
	private String col2;

	@Column(name = "col3")
	private String col3;

	
}
