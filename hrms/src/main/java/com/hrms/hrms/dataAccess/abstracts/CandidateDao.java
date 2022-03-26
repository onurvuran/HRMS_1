package com.hrms.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	Optional<Candidate> findByIdentityNumber(String nationalIdentity);
	Optional<Candidate> findByEmail(String email);

}
