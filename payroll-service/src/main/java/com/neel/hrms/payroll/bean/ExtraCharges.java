package com.neel.hrms.payroll.bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "extraCharges")
public class ExtraCharges {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long charhesId;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="empctcid")
	private EmployeeCTCAccessBean employeeCTCAccessBean;	
	
     private Long mediclame;
     
     private Long bonus;
     
     private Long incentives;
     
     private Long tds;

	
	
}
