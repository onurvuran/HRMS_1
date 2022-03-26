package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.EmployeeVerificationService;
import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.abstracts.utilities.adapters.Businness.BusinessRules;
import com.hrms.hrms.core.abstracts.utilities.adapters.emailVerification.EmailVerificationService;
import com.hrms.hrms.core.abstracts.utilities.result.DataResult;
import com.hrms.hrms.core.abstracts.utilities.result.ErrorResult;
import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.core.abstracts.utilities.result.SuccessDataResult;
import com.hrms.hrms.core.abstracts.utilities.result.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private EmployeeVerificationService employeeVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			EmployeeVerificationService employeeVerificationService) {
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.employeeVerificationService = employeeVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {

		final Result result = BusinessRules.run(this.emailVerificationService.verify(employer.getEmail()),
				this.employeeVerificationService.verifyEmployer(employer), isEmailExists(employer));

		if (!result.isSuccess()) {
			return result;
		}

		this.employerDao.save(employer);
		return new SuccessResult("iş veren eklendi.");
	}

	public Result isEmailExists(Employer employer) {
		return this.employerDao.findByEmail(employer.getEmail()).isEmpty() ? new SuccessResult()
				: new ErrorResult("EBu email zaten kullanılıyor!");
	}

}