package com.hrms.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	

}
