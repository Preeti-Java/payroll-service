package com.neel.hrms.payroll.bean;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pftransaction")
public class PfTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pfTransId")
	private Long pfTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pfId", referencedColumnName = "pfId")
	private PfAccessBean pfAccessBean;

	@Column(name = "pfAmount")
	private Long pfAmount;

	@Column(name = "lastDeductionDate")
	private String lastDeductionDate;

	

}
