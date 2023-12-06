package com.neel.hrms.payroll.bean;

import java.util.Date;

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
	private Long employeeId;

	@Column(name = "startDay")
	private Date startDay;

	@Column(name = "hoursWorked")
	private Long hoursWorked;

	@Column(name = "grossPay")
	private Long grossPay;

	@Column(name = "deduction")
	private Long deduction;

	@Column(name = "netPay")
	private Long netPay;

	@Column(name = "accountId")
	private Long accountId;
	
	@Column(name = "totalDay")
	private Long totalDay;

	@Column(name = "endDay")
	private Long endDay;

	@Column(name = "col2")
	private String col2;

	@Column(name = "col3")
	private String col3;

	
}
