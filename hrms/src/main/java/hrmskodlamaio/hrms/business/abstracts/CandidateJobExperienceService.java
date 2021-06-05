package hrmskodlamaio.hrms.business.abstracts;

import java.util.List;

import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateJobExperience;
import hrmskodlamaio.hrms.entities.concretes.CandidateSchool;

public interface CandidateJobExperienceService {

	Result add(CandidateJobExperience candidateJobExperience);
	
	DataResult<List<CandidateJobExperience>> getAll();
	
	DataResult<List<CandidateJobExperience>> findAllByCandidateCvIdOrderByYearOfLeavingDesc(int id);
}
