package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.core.abstracts.utilities.adapters.Businness.BusinessRules;
import com.hrms.hrms.core.abstracts.utilities.adapters.emailVerification.EmailVerificationService;
import com.hrms.hrms.core.abstracts.utilities.adapters.mernis.MernisCheckService;
import com.hrms.hrms.core.abstracts.utilities.adapters.mernis.PersonForMernisCheckService;
import com.hrms.hrms.core.abstracts.utilities.result.DataResult;
import com.hrms.hrms.core.abstracts.utilities.result.ErrorResult;
import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.core.abstracts.utilities.result.SuccessDataResult;
import com.hrms.hrms.core.abstracts.utilities.result.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	@Autowired
	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;
	private EmailVerificationService emailVerificationService;

	public CandidateManager(CandidateDao candidateDao, MernisCheckService mernisCheckService,
			EmailVerificationService emailVerificationService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisCheckService = mernisCheckService;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public DataResult<List<Candidate>> getall() {

		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Veriler Listelendi.");

	}

	@Override
	public Result add(Candidate candidate) {
		final Result result = BusinessRules.run(
				this.mernisCheckService.checkIfRealPerson(
						new PersonForMernisCheckService(Long.parseLong(candidate.getIdentityNumber()),
								candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear())),
				isEmailExists(candidate), isNationalIdentityExists(candidate),
				this.emailVerificationService.verify(candidate.getEmail()));
		if (!result.isSuccess()) {
			return result;
		}

		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added");
	}

	public Result isNationalIdentityExists(Candidate candidate) {
		return this.candidateDao.findByIdentityNumber(candidate.getIdentityNumber()).isEmpty() ? new SuccessResult()
				: new ErrorResult("National identity is exists!");
	}

	public Result isEmailExists(Candidate candidate) {
		return this.candidateDao.findByEmail(candidate.getEmail()).isEmpty() ? new SuccessResult()
				: new ErrorResult("Email is exists!");
	}

}
