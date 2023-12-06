package com.neel.hrms.payroll.bean;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "loantransaction")
public class LoanTransactionAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LoanTransId")
	private Long loanTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loanId", referencedColumnName = "loanId")
	private LoanAccessBean loanAccessBean;

	@Column(name = "LoanAmount")
	private Long loanAmount;

	@Column(name = "lastDeductionDate")
	private Date lastDeductionDate;

	
}
