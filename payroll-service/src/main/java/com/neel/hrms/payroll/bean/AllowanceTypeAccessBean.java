package com.neel.hrms.payroll.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "allowancetype")
public class AllowanceTypeAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "allowanceTypeId")
	private Long allowanceTypeId;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "allowancesId", nullable = false) private
	 * AllowancesAccessBean allowancesAccessBean;
	 */
	@Column(name = "allowanceType")
	private String allowanceType;

	@Column(name = "description")
	private String description;

	

}
