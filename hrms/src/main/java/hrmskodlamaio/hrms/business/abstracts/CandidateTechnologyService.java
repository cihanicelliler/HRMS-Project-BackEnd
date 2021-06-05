package hrmskodlamaio.hrms.business.abstracts;

import java.util.List;

import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateLanguage;
import hrmskodlamaio.hrms.entities.concretes.CandidateTechnology;

public interface CandidateTechnologyService {
	Result add(CandidateTechnology candidateLanguage);
	
	DataResult<List<CandidateTechnology>> getAll();
}
