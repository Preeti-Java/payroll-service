package com.neel.hrms.payroll.bean;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deductions")
public class DeductionsAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deductionsId")
	private Long deductionsId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "deductionsAccessBean")
	private List<DeductionTypesAccessBean> deductionTypesAccessBean;

	@OneToOne(mappedBy = "deductionsAccessBean")
	private DeductionTransAccessBean deductionTransAccessBean;

	@Column(name = "employeeId")
	private Long employeeId;

	@Column(name = "dedEffectiveDate")
	private Date dedEffectiveDate;

	@Column(name = "dedEndDate")
	private Date dedEndDate;

	@Column(name = "netDedAmount")
	private Long netDedAmount;

	@Column(name = "dedInstAmt")
	private Long dedInstAmt;



}
