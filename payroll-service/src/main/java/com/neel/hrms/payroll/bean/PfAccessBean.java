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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pf")
public class PfAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pfId")
	private Long pfId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pfAccessBean")
	private List<PfTypesAccessBean> pfTypesAccessBean;

	@OneToOne(mappedBy = "pfAccessBean")
	private PfTransAccessBean pfTransAccessBean;

	@Column(name = "employeeId")
	private Long employeeId;

	@Column(name = "pfEffectiveDate")
	private Date pfEffectiveDate;

	@Column(name = "pfEndDate")
	private Date pfEndDate;

	@Column(name = "netPFAmount")
	private Long netPFAmount;

	
}
