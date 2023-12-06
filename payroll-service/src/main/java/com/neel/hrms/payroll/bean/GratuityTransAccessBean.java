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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gratuitytransaction")
public class GratuityTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GratuityTransId")
	private Long gratuityTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gratuityId", referencedColumnName = "gratuityId")
	private GratuityAccessBean gratuityAccessBean;

	@Column(name = "GratuityAmount")
	private Long gratuityAmount;

	@Column(name = "lastDeductionDate")
	private Date lastDeductionDate;



}
