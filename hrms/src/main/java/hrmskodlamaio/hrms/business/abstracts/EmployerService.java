package hrmskodlamaio.hrms.business.abstracts;

import java.util.List;

import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.Employer;
import hrmskodlamaio.hrms.entities.concretes.DTOs.EmployerForRegisterDto;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();

	Result register(EmployerForRegisterDto employer);
}
