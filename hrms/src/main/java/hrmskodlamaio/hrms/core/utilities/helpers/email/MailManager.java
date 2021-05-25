package hrmskodlamaio.hrms.core.utilities.helpers.email;

import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class MailManager implements MailService{

	@Override
	public Result send(String to, String title, String message) {
		return new SuccessResult("The e-mail has been sent successfully.");
	}

}
