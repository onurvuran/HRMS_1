package com.hrms.hrms.core.abstracts.utilities.adapters.mernis;

import com.hrms.hrms.core.abstracts.utilities.result.Result;

public interface MernisCheckService {

	Result checkIfRealPerson(PersonForMernisCheckService person);

}
