package com.neel.hrms.payroll.bean;



import jakarta.persistence.Column;
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
public class TaxCalculateAccessBean {

	
	@Column(name = "TaxCalId")
	private Long taxId;

	@Column(name = "AgeGroup")
	private String ageGroup;

	@Column(name = "interestIncome")
	private double interestIncome;

	@Column(name = "occupiedPropertyInterest")
	private double occupiedPropertyInterest;
	
	@Column(name = "taxableSalary")
	private double taxableSalary;

	@Column(name = "rentalPropertyIncome")
	private double rentalPropertyIncome;

	@Column(name = "exemptIncome")
	private double exemptIncome;
	
	@Column(name = "otherIncome")
	private double otherIncome;

	@Column(name = "interestLoan")
	private double interestLoan;

	@Column(name = "section80C")
	private double section80C;
	
	@Column(name = "section80D")
	private double section80D;

	@Column(name = "section80E")
	private double section80E;

	@Column(name = "section80CCD")
	private double section80CCD;
	
	@Column(name = "section80TTA")
	private double section80TTA;

	@Column(name = "section80G")
	private double section80G;

	@Column(name = "section80EEA")
	private double section80EEA;


}
