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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ecistransaction")
public class EcisTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ecisTransId")
	private Long ecisTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ecisId", referencedColumnName = "ecisId")
	private EcisAccessBean ecisAccessBean;

	@Column(name = "ecisAmount")
	private Long ecisAmount;

	@Column(name = "lastDeductionDate")
	private Date lastDeductionDate;

	

}
