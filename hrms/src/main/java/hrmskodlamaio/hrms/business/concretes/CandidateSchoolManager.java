package hrmskodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.CandidateSchoolService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDao;
import hrmskodlamaio.hrms.entities.concretes.CandidateSchool;

@Service
public class CandidateSchoolManager implements CandidateSchoolService{
	
	private CandidateSchoolDao candidateSchoolDao;

	@Autowired
	public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao) {
		super();
		this.candidateSchoolDao = candidateSchoolDao;
	}

	@Override
	public Result add(CandidateSchool candidateSchool) {
		this.candidateSchoolDao.save(candidateSchool);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateSchool>> findAllByCandidateCvIdOrderByGraduationYearDesc(int id) {
		return new SuccessDataResult<List<CandidateSchool>>(this.candidateSchoolDao.findAll());
	}

}
