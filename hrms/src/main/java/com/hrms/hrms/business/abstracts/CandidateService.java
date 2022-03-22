package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.abstracts.utilities.result.DataResult;
import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getall();
	Result add(Candidate candidate);

}
