package hrmskodlamaio.hrms.business.abstracts;

import java.util.List;

import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {

	Result add(CandidateLanguage candidateLanguage);
	
	DataResult<List<CandidateLanguage>> getAll();
}
