package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.core.abstracts.utilities.result.DataResult;
import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	@Autowired
	private CandidateService candidateService;

	public CandidatesController(CandidateService candiateSerive) {
		super();
		this.candidateService = candiateSerive;
	}
	
	@GetMapping("getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}

	
	@PostMapping("add")
	public Result add(@RequestBody Candidate candidate){
		
		return  this.candidateService.add(candidate); 
		
	};
	
	

}
