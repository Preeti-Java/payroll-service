package com.neel.hrms.payroll.bean;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "tax")
public class TaxAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TaxId")
	private Long taxId;

	@OneToOne(mappedBy = "taxAccessBean")
	private TaxTransAccessBean taxTransAccessBean;

	@Column(name = "employeeId")
	private String employeeId;

	@Column(name = "TaxEffectiveDate")
	private Date taxEffectiveDate;

	@Column(name = "TaxEndDate")
	private Date taxEndDate;

	@Column(name = "netTaxAmount")
	private Long netTaxAmount;

	@Column(name = "TaxTypeId")
	private Long taxTypeId;



}
