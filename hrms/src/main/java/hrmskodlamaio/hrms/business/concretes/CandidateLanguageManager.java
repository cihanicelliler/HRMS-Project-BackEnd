package hrmskodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.CandidateLanguageService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import hrmskodlamaio.hrms.entities.concretes.CandidateLanguage;

@Service
public class CandidateLanguageManager implements CandidateLanguageService{
	
	private CandidateLanguageDao candidateLanguageDao;

	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
	}

	@Override
	public Result add(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll());
	}

}
