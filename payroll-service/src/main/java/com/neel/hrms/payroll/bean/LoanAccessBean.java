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
@Table(name = "loan")
public class LoanAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LoanId")
	private Long loanId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "loanAccessBean")
	private List<LoanTypesAccessBean> loanTypesAccessBean;

	@OneToOne(mappedBy = "loanAccessBean")
	private LoanTransactionAccessBean loanTransactionAccessBean;

	@Column(name = "employeeId")
	private Long employeeId;

	@Column(name = "LoanEffectiveDate")
	private Date loanEffectiveDate;

	@Column(name = "LoanEndDate")
	private Date loanEndDate;

	@Column(name = "netLoanAmount")
	private Long netLoanAmount;

	@Column(name = "LoanTypeId")
	private Long loanTypeId;


}
