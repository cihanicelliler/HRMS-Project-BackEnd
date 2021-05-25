package hrmskodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.CandidateService;
import hrmskodlamaio.hrms.business.abstracts.UserService;
import hrmskodlamaio.hrms.core.utilities.IdentityValidationService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.ErrorResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import hrmskodlamaio.hrms.entities.concretes.Candidate;
import hrmskodlamaio.hrms.entities.concretes.User;
import hrmskodlamaio.hrms.entities.concretes.DTOs.CandidateForRegisterDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserService userService;
	private IdentityValidationService identityValidationService;

	public CandidateManager(CandidateDao candidateDao, UserService userService,
			IdentityValidationService identityValidationService) {
		super();
		this.candidateDao = candidateDao;
		this.userService = userService;
		this.identityValidationService = identityValidationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll());
	}

	@Override
	public Result register(CandidateForRegisterDto candidate) {
		if (runAllRules(candidate) != null)
			return runAllRules(candidate);
		if (!identityValidationService.validate(candidate.getNationalityId(), candidate.getFirstName(),
				candidate.getLastName(), candidate.getDateOfBirth().getYear()).isSuccess()) {
			return new ErrorResult("TC Identity Number verification failed.");
		}
		User userToRegister = new User(candidate.getEmail(), candidate.getPassword(), false,
				UUID.randomUUID().toString());
		userService.add(userToRegister);
		Candidate candidateToRegister = new Candidate(userToRegister.getId(), candidate.getFirstName(),
				candidate.getLastName(), candidate.getNationalityId(), candidate.getDateOfBirth());
		this.candidateDao.save(candidateToRegister);
		return new SuccessResult(
				"Job seeker registration is successful. Please verify your account with the verification link sent to your e-mail address.");
	}

	private Result runAllRules(CandidateForRegisterDto employee) {
		if (isAllFieldsFilled(employee) != null)
			return isAllFieldsFilled(employee);
		if (isPasswordsMatch(employee) != null)
			return isPasswordsMatch(employee);
		if (isUserExistWithEmail(employee) != null)
			return isUserExistWithEmail(employee);
		if (isUserExistWithNationalityId(employee) != null)
			return isUserExistWithNationalityId(employee);

		return null;
	}

	private Result isAllFieldsFilled(CandidateForRegisterDto employee) {
		if (employee.getVerifyPassword() == null || employee.getVerifyPassword().equals("")
				|| employee.getPassword() == null || employee.getPassword().equals("") || employee.getEmail() == null
				|| employee.getEmail().equals("") || employee.getNationalityId() == null
				|| employee.getNationalityId().equals("") || employee.getLastName() == null
				|| employee.getLastName().equals("") || employee.getFirstName() == null
				|| employee.getFirstName().equals("") || employee.getDateOfBirth() == null)
			return new ErrorResult("You must fill in all fields.");
		return null;
	}

	private Result isPasswordsMatch(CandidateForRegisterDto employee) {
		if (!employee.getPassword().equals(employee.getVerifyPassword())) {
			return new ErrorResult("Passwords must match.");
		}
		return null;
	}

	private Result isUserExistWithEmail(CandidateForRegisterDto employee) {
		if (userService.getByEmail(employee.getEmail()).getData() != null)
			return new ErrorResult("Another user exists with this e-mail address.");
		return null;
	}

	private Result isUserExistWithNationalityId(CandidateForRegisterDto candidate) {
		if (candidateDao.findByIdentityNumber(candidate.getNationalityId()) != null)
			return new ErrorResult("There is another user with this TCKN Number.");
		return null;
	}

}
