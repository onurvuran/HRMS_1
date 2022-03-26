package com.hrms.hrms.core.abstracts.utilities.adapters.emailVerification;

import org.springframework.stereotype.Service;

import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.core.abstracts.utilities.result.SuccessResult;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public Result verify(String email) {

		return new SuccessResult();
	}

}
