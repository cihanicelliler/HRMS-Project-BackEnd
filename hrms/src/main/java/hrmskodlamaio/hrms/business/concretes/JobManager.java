package hrmskodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmskodlamaio.hrms.business.abstracts.JobService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.ErrorResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.core.utilities.results.SuccessDataResult;
import hrmskodlamaio.hrms.core.utilities.results.SuccessResult;
import hrmskodlamaio.hrms.dataAccess.abstracts.JobDao;
import hrmskodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> GetAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll());
	}

	@Override
	public DataResult<Job> getByTitle(String title) {
		return new SuccessDataResult<Job>(this.jobDao.findByTitle(title));
	}

	@Override
	public Result addNew(Job job) {
		if (job.getTitle() == null || job.getTitle() == "")
			return new ErrorResult("Job position name cannot be left blank.");
		if (getByTitle(job.getTitle()).getData() != null)
			return new ErrorResult("Two job positions with the same name cannot be created.");
		this.jobDao.save(job);
		return new SuccessResult("Job position has been added.");
	}

}
