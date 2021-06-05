package hrmskodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import hrmskodlamaio.hrms.entities.concretes.CandidateJobExperience;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService{

	private CandidateJobExperienceDao candidateJobExpreinceDao;
	
	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExpreinceDao) {
		super();
		this.candidateJobExpreinceDao = candidateJobExpreinceDao;
	}

	@Override
	public Result add(CandidateJobExperience candidateJobExperience) {
		this.candidateJobExpreinceDao.save(candidateJobExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {
		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExpreinceDao.findAll());
	}

	@Override
	public DataResult<List<CandidateJobExperience>> findAllByCandidateCvIdOrderByYearOfLeavingDesc(int id) {
		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExpreinceDao.findAllByCandidateCvIdOrderByYearOfLeavingDesc(id));
	}

}
