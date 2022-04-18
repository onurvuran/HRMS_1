package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobTitleService;
import com.hrms.hrms.core.abstracts.utilities.adapters.Businness.BusinessRules;
import com.hrms.hrms.core.abstracts.utilities.result.ErrorResult;
import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.core.abstracts.utilities.result.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.hrms.entities.concretes.JobTitle;

@Service
public class JobTitileManager implements JobTitleService {
	@Autowired
	private JobTitleDao jobTitleDao;

	public JobTitileManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}

	@Override
	public Result add(JobTitle jobTitle) {
		final Result result = BusinessRules.run(isJobExists(jobTitle));

		if (!result.isSuccess()) {
			return result;
		}

		this.jobTitleDao.save(jobTitle);

		return new SuccessResult("iş başlığı eklendi.");
	}

	public Result isJobExists(JobTitle jobTitle) {
		return this.jobTitleDao.findByTitle(jobTitle.getTitle()).isEmpty() ? new SuccessResult()
				: new ErrorResult("Bu başlık zaten kullanılıyor.");
	}

}
