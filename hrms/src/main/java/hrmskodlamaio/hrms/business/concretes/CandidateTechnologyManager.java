package hrmskodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.CandidateTechnologyService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.CandidateTechnologyDao;
import hrmskodlamaio.hrms.entities.concretes.CandidateTechnology;

@Service
public class CandidateTechnologyManager implements CandidateTechnologyService{

	
	private CandidateTechnologyDao candidateTechnologyDao;
	
	@Autowired
	public CandidateTechnologyManager(CandidateTechnologyDao candidateTechnologyDao) {
		super();
		this.candidateTechnologyDao = candidateTechnologyDao;
	}

	@Override
	public Result add(CandidateTechnology candidateLanguage) {
		this.candidateTechnologyDao.save(candidateLanguage);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateTechnology>> getAll() {
		return new SuccessDataResult<List<CandidateTechnology>>(this.candidateTechnologyDao.findAll());
	}

}
