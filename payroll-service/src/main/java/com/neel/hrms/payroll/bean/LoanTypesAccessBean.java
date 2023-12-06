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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loantypes")
public class LoanTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LoanTypeId")
	private Long loanTypeId;

	@ManyToOne
	@JoinColumn(name = "LoanId", nullable = false)
	private LoanAccessBean loanAccessBean;

	@Column(name = "LoanType")
	private String loanType;

	@Column(name = "LoanDescription")
	private String loanDescription;

	

}
