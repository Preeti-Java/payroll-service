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
@Table(name = "ecis")
public class EcisAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ECISId")
	private Long ecisId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ecisAccessBean")
	private List<EcisTypesAccessBean> ecisTypesAccessBean;

	@OneToOne(mappedBy = "ecisAccessBean")
	private EcisTransAccessBean ecisTransAccessBean;

	@Column(name = "employeeId")
	private String employeeId;

	@Column(name = "ECISEffectiveDate")
	private Date ecisEffectiveDate;

	@Column(name = "netECISAmount")
	private Date netECISAmount;

	@Column(name = "ecisTypeId")
	private Long ecisTypeId;

	
}
