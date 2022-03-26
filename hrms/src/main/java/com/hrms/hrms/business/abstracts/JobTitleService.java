package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	List<JobTitle> getAll();

	Result add(JobTitle jobTitle);

}
