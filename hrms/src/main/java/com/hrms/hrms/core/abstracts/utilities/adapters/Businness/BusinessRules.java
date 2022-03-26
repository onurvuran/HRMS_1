package com.hrms.hrms.core.abstracts.utilities.adapters.Businness;

import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.core.abstracts.utilities.result.SuccessResult;

public class BusinessRules {

	public static Result run(final Result... logics) {
		for (final Result logic : logics) {
			if (!logic.isSuccess()) {
				return logic;
			}
		}

		return new SuccessResult();
	}

}
