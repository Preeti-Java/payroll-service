package com.neel.hrms.payroll.bean;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "deductiontransaction")
public class DeductionTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dedTransId")
	private Long dedTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deductionsId", referencedColumnName = "deductionsId")
	private DeductionsAccessBean deductionsAccessBean;

	@Column(name = "dedAmount")
	private Long dedAmount;

	@Column(name = "lastDeductionDate")
	private Date lastDeductionDate;

	
}
