package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.EmployeeVerification;

public interface EmployeeVerificationDao extends JpaRepository<EmployeeVerification, Integer>{

}
