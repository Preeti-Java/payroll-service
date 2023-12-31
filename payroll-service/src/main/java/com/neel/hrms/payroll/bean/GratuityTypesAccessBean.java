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
@Table(name = "gratuitytypes")
public class GratuityTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GratuityTypeId")
	private Long gratuityTypeId;

	@ManyToOne
	@JoinColumn(name = "GratuityId", nullable = false)
	private GratuityAccessBean gratuityAccessBean;

	@Column(name = "GratuityType")
	private String gratuityType;

	@Column(name = "GratuityDescription")
	private String gratuityDescription;

	
}
