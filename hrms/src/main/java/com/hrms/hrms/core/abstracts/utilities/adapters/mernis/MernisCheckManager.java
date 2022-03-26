package com.hrms.hrms.core.abstracts.utilities.adapters.mernis;

import org.springframework.stereotype.Service;

import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.core.abstracts.utilities.result.SuccessResult;

@Service
public class MernisCheckManager implements MernisCheckService {

	@Override
	public Result checkIfRealPerson(PersonForMernisCheckService person) {

		return new SuccessResult();
	}

}
