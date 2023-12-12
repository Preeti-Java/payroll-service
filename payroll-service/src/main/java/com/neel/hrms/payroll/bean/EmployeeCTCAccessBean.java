package com.neel.hrms.payroll.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
 *Preeti Dhiman
*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employeectc")
public class EmployeeCTCAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeCTCId")
	private Long employeeCTCId;

	@Column(name = "EmployeeId")
	private String employeeId;

	@Column(name = "Name")
	private String name;

	@Column(name = "JoiningDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;

	@Column(name = "AnnualBasicSalary")
	private Long annualBasicSalary;

	@Column(name = "AnnualRefSalary")
	private Long annualRefSalary;

	@Column(name = "PF")
	private Long pf;

	@Column(name = "HRA")
	private Long hra;

	@Column(name = "CONVEY")
	private Long convey;

	@Column(name = "ESI")
	private Long esi;

	@Column(name = "Gratuity")
	private Long gratuity;

	@Column(name = "CTC")
	private Long cTC;

	@Column(name = "IncrementDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date incrementDate;

	@Column(name = "newCtc")
	private Long newCtc;

	@Column(name = "Comments")
	private String comments;

	@Column(name = "AnnualFlexibleBenifits")
	private Long annualFlexibleBenifits;

	@Column(name = "Mediclaime")
	private Long mediclame;

	@Column(name = "TravelExpensis")
	private Long travelExpensis;

	@Column(name = "Bonus")
	private Long bonus;

	@Column(name = "Incentives")
	private Long incentives;

	@Column(name = "tds")
	private Long tds;

	

}
