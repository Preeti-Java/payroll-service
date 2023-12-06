package com.neel.hrms.payroll.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "deductiontypes")
public class DeductionTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deductionTypesId")
	private Long deductionTypesId;

	@ManyToOne
	@JoinColumn(name = "deductionsId", nullable = false)
	private DeductionsAccessBean deductionsAccessBean;

	@Column(name = "deductionType")
	private String deductionType;

	@Column(name = "deductionDescription")
	private String deductionDescription;

	

}
