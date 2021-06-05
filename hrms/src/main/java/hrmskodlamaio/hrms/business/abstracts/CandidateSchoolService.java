package hrmskodlamaio.hrms.business.abstracts;

import java.util.List;

import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateSchool;

public interface CandidateSchoolService {

	Result add(CandidateSchool candidateSchool);
	
	DataResult<List<CandidateSchool>> findAllByCandidateCvIdOrderByGraduationYearDesc(int id);
}
