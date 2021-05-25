package hrmskodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.EmployerService;
import hrmskodlamaio.hrms.business.abstracts.UserService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.ErrorResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import hrmskodlamaio.hrms.entities.concretes.Employer;
import hrmskodlamaio.hrms.entities.concretes.User;
import hrmskodlamaio.hrms.entities.concretes.DTOs.EmployerForRegisterDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserService userService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result register(EmployerForRegisterDto employer) {
		if (runAllRegisterRules(employer) != null)
			return runAllRegisterRules(employer);
		User userToRegister = new User(employer.getEmail(), employer.getPassword(), false,
				UUID.randomUUID().toString());
		userService.add(userToRegister);
		Employer employerToRegister = new Employer(userToRegister.getId(), employer.getCompanyName(),
				employer.getWebsite(), employer.getPhone(), false);
		this.employerDao.save(employerToRegister);
		return new SuccessResult(
				"The employer has successfully registered. Please verify your membership by clicking the link sent to your e-mail address.");
	}

	private Result runAllRegisterRules(EmployerForRegisterDto employer) {
		if (isAllFieldsFilled(employer) != null)
			return isAllFieldsFilled(employer);
		if (isPasswordsSame(employer) != null)
			return isPasswordsSame(employer);
		if (isEmailandWebsiteDomainSame(employer) != null)
			return isEmailandWebsiteDomainSame(employer);
		if (isEmailAlreadyInUse(employer) != null)
			return isEmailAlreadyInUse(employer);
		return null;
	}

	private Result isAllFieldsFilled(EmployerForRegisterDto employer) {
		if (employer.getCompanyName() == null || employer.getPhone() == null || employer.getWebsite() == null
				|| employer.getEmail() == null || employer.getPassword() == null
				|| employer.getVerifyPassword() == null)
			return new ErrorResult("No field should be left blank.");
		if (employer.getCompanyName().equals("") || employer.getPhone().equals("") || employer.getWebsite().equals("")
				|| employer.getEmail().equals("") || employer.getPassword().equals("")
				|| employer.getVerifyPassword().equals(""))
			return new ErrorResult("No field should be left blank.");
		return null;
	}

	private Result isPasswordsSame(EmployerForRegisterDto employer) {
		if (!employer.getPassword().equals(employer.getVerifyPassword()))
			return new ErrorResult("Your passwords do not match.");
		return null;
	}

	private Result isEmailandWebsiteDomainSame(EmployerForRegisterDto employer) {
		String email = employer.getEmail();
		String[] emailSplit = email.split("@");
		if (!emailSplit[1].equals(employer.getWebsite()))
			return new ErrorResult("The domain of your e-mail address must be the same as your website.");
		return null;
	}

	private Result isEmailAlreadyInUse(EmployerForRegisterDto employer) {
		if (userService.getByEmail(employer.getEmail()).getData() != null)
			return new ErrorResult("There is a registered user with this e-mail address.");
		return null;
	}

}
