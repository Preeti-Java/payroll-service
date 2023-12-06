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
@Table(name = "gratuity")
public class GratuityAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GratuityId")
	private Long gratuityId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "gratuityAccessBean")
	private List<GratuityTypesAccessBean> gratuityTypesAccessBean;

	@OneToOne(mappedBy = "gratuityAccessBean")
	private GratuityTransAccessBean gratuityTransAccessBean;

	@Column(name = "employeeId")
	private Long employeeId;
	
	@Column(name = "GratuityEffectiveDate")
	private Date gratuityEffectiveDate;

	@Column(name = "GratuityEndDate")
	private Date gratuityEndDate;

	@Column(name = "netGratuityAmount")
	private Long netGratuityAmount;

	@Column(name = "GratuityTypeId")
	private Long gratuityTypeId;


}
