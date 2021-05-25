package hrmskodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.UserService;
import hrmskodlamaio.hrms.core.utilities.helpers.email.MailService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.ErrorResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.UserDao;
import hrmskodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private MailService emailService;

	@Autowired
	public UserManager(UserDao userDao, MailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll());
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(userDao.findByEmail(email));
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		this.emailService.send(user.getEmail(), "Verification Link",
				"Welcome to the HRMS System." + "You can verify your membership by clicking the link below. \n "
						+ "www.localhost:8080/api/users/verify?email=" + user.getEmail() + "&verifycode="
						+ user.getEmailVerifyCode());
		return new SuccessResult();
	}

	@Override
	public Result verifyUser(String email, String verificationCode) {
		User user = userDao.findByEmailAndEmailVerifyCode(email, verificationCode);
		if(user == null)
			return new ErrorResult("Verification failed please make sure you entered the correct information.");
		
		user.setEmailVerified(true);
		userDao.save(user);
		return new SuccessResult("The user email has been successfully verified.");
	}

}
