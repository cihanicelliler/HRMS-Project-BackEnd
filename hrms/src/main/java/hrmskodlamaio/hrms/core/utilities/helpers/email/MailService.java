package hrmskodlamaio.hrms.core.utilities.helpers.email;

import hrmskodlamaio.hrms.core.utilities.results.Result;

public interface MailService {
	Result send(String to , String title, String message);
}
