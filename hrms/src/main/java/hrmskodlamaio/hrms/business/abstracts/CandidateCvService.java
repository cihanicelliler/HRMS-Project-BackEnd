package hrmskodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateCv;

public interface CandidateCvService {
	DataResult<List<CandidateCv>> getAll();
	
	Result add(CandidateCv candidateCv);
	
	DataResult<List<CandidateCv>> getAllBySortedGraduationYear();
	
	DataResult<List<CandidateCv>> getAllBySortedYearOfLeaving();

}
