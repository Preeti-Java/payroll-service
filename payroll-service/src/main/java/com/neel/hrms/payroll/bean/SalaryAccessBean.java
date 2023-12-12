package com.neel.hrms.payroll.bean;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salary")
public class SalaryAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salaryId")
	private Long salaryId;

	@Column(name = "employeeId")
	private String employeeId;
	
	@Column(name = "HRA")
	private Long hra;

	@Column(name = "totalDeduction")
	private Long totalDeduction;

	@Column(name = "totalPF")
	private Long totalPF;

	@Column(name = "totalECIS")
	private Long totalECIS;

	@Column(name = "totalTax")
	private Long totalTax;

	@Column(name = "totalGratuity")
	private Long totalGratuity;

	@Column(name = "totalLoan")
	private Long totalLoan;

	@Column(name = "netPay")
	private Long netPay;

	@Column(name = "grossPay")
	private Long grossPay;

	@Column(name = "totalAllowances")
	private Long totalAllowances;



}
