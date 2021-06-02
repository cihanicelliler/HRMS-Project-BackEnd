package hrmskodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.CandidateCvService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import hrmskodlamaio.hrms.entities.concretes.CandidateCv;

@Service
public class CandidateCvManager implements CandidateCvService{

	private CandidateCvDao candidateCvDao;
	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao) {
		super();
		this.candidateCvDao = candidateCvDao;
	}

	@Override
	public DataResult<List<CandidateCv>> getAll() {
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findAll());
	}

	@Override
	public Result add(CandidateCv candidateCv) {
		this.candidateCvDao.save(candidateCv);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateCv>> getAllBySortedGraduationYear() {
		Sort sort = Sort.by(Sort.Direction.DESC,"graduationYear");
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findAll(sort));
	}

	@Override
	public DataResult<List<CandidateCv>> getAllBySortedYearOfLeaving() {
		Sort sort = Sort.by(Sort.Direction.DESC,"yearOfLeaving");
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findAll(sort));
	}
}
