package hrmskodlamaio.hrms.business.abstracts;

import java.util.List;

import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.Job;

public interface JobService {
	DataResult<List<Job>> GetAll();
	DataResult<Job> getByTitle(String title);
    Result addNew(Job job);
}
