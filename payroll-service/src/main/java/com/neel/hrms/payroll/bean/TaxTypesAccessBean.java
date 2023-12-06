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
@Table(name = "taxtypes")
public class TaxTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TaxTypeId")
	private Long taxTypeId;

	@Column(name = "TaxType")
	private Long taxType;

	@Column(name = "TaxDescription")
	private String taxDescription;

	

}
