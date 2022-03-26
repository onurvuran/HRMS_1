package com.hrms.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
	Optional<Job> findByName(String name);

	

}
