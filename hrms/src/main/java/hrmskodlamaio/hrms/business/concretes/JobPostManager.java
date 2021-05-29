package hrmskodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.JobPostService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.JobPostDao;
import hrmskodlamaio.hrms.entities.concretes.JobPost;

@Service
public class JobPostManager implements JobPostService{
	private JobPostDao jobPostDao;

	public JobPostManager(JobPostDao jobPostDao) {
		super();
		this.jobPostDao = jobPostDao;
	}

	@Override
	public DataResult<List<JobPost>> getByStatus(boolean status) {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByStatus(true),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobPost>> getByStatusAndReleaseDate(boolean status, Date releaseDate) {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByStatusAndReleaseDate(true,releaseDate),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobPost>> getByStatusAndDeadlineDate(boolean status, Date deadlineDate) {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByStatusAndDeadlineDate(true,deadlineDate),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobPost>> getByStatusAndEmployer_CompanyName(boolean status, String companyName) {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByStatusAndEmployer_CompanyName(true,companyName),"Data Listelendi");
	}

	@Override
	public Result add(JobPost jobPost) {
		this.jobPostDao.save(jobPost);
		return new SuccessResult("Added to data");
	}

}
