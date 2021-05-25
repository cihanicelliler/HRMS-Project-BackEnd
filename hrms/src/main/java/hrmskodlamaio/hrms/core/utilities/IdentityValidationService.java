package hrmskodlamaio.hrms.core.utilities;

import hrmskodlamaio.hrms.core.utilities.results.Result;

public interface IdentityValidationService {
	Result validate(String tckn,String firstName, String lastName, int yearOfBD);
}
