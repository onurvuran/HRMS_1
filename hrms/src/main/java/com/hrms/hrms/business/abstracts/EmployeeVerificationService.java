package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.abstracts.utilities.result.DataResult;
import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.entities.concretes.EmployeeVerification;
import com.hrms.hrms.entities.concretes.Employer;

public interface EmployeeVerificationService {

	DataResult<List<EmployeeVerification>> getAll();

	Result add(EmployeeVerification employeeVerification);

	Result verifyEmployer(Employer employer);

}
