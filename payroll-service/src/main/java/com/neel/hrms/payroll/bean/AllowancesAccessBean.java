package com.neel.hrms.payroll.bean;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *	@Author
 *	Preeti Rani
*/


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "allowances")
public class AllowancesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "allowancesId")
	private Long allowancesId;

	@Column(name = "allowanceTypeId")
	private Long allowanceTypeId;

	@OneToOne(mappedBy = "allowancesAccessBean")
	private AllowanceTransAccessBean allowanceTransAccessBean;

	@Column(name = "employeeId")
	private String employeeId;

	@Column(name = "effectiveDate")
	private Date effectiveDate;

	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "allowancesAmt")
	private Long allowancesAmt;

	
}
