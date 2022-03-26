package com.hrms.hrms.core.abstracts.utilities.adapters.emailVerification;

import com.hrms.hrms.core.abstracts.utilities.result.Result;

public interface EmailVerificationService {

	Result verify(String email);

}
