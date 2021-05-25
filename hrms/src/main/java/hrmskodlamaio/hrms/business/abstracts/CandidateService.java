package hrmskodlamaio.hrms.business.abstracts;

import java.util.List;

import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.Candidate;
import hrmskodlamaio.hrms.entities.concretes.DTOs.CandidateForRegisterDto;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();

	Result register(CandidateForRegisterDto candidate);
}
