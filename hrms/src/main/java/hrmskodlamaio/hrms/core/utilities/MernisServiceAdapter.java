package hrmskodlamaio.hrms.core.utilities;

import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisServiceAdapter implements IdentityValidationService{

	@Override
	public Result validate(String tckn, String firstName, String lastName, int yearOfBD) {
		return new SuccessResult("Authentication successful.");
	}

}
