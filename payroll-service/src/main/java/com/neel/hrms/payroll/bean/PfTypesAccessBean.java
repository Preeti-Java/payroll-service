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
@Table(name = "pfTypes")
public class PfTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pfTypeId")
	private Long pfTypeId;

	@ManyToOne
	@JoinColumn(name = "pfId", nullable = false)
	private PfAccessBean pfAccessBean;

	@Column(name = "pfType")
	private Long pfType;

	@Column(name = "pfDescription")
	private String pfDescription;



}
