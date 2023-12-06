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

import org.springframework.format.annotation.DateTimeFormat;

/*
 *	@Author
 *	Preeti Dhiman
*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "allowancetransaction")
public class AllowanceTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "allowanceTransId")
	private Long allowanceTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "allowancesId", referencedColumnName = "allowancesId")
	private AllowancesAccessBean allowancesAccessBean;

	@Column(name = "allowanceAmt")
	private Long allowanceAmt;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "lastTransDate")
	private Date lastTransDate;


}
