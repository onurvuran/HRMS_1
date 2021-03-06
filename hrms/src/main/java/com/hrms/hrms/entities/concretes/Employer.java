package com.hrms.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User {
//	@Id
//	@Column(name = "employer_id")
//	private String employer_id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_address")
	private String website;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToOne(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private EmployeeVerification employeeVerification;
	
	
	

}
