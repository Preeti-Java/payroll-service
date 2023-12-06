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
@Table(name = "ecistypes")
public class EcisTypesAccessBean {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eTypeId")
	private Long ecisTypeId;

	@ManyToOne
	@JoinColumn(name = "ecisId", nullable = false)
	private EcisAccessBean ecisAccessBean;

	@Column(name = "ecisType")
	private String ecisType;

	@Column(name = "LogonPassword")
	private String logonPassword;

	

}
