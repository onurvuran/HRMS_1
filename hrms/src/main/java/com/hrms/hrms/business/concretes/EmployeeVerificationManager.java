package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.EmployeeVerificationService;
import com.hrms.hrms.core.abstracts.utilities.result.DataResult;
import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.core.abstracts.utilities.result.SuccessResult;
import com.hrms.hrms.entities.concretes.EmployeeVerification;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployeeVerificationManager implements EmployeeVerificationService {

	@Override
	public DataResult<List<EmployeeVerification>> getAll() {

		return null;
	}

	@Override
	public Result add(EmployeeVerification employeeVerification) {

		return null;
	}

	@Override
	public Result verifyEmployer(Employer employer) {

		return new SuccessResult();
	}

}
