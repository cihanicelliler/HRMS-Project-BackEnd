package hrmskodlamaio.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.JobPost;

public interface JobPostService {
	DataResult<List<JobPost>> getByStatus(boolean status);

	DataResult<List<JobPost>> getByStatusAndReleaseDate(boolean status, Date releaseDate);

	DataResult<List<JobPost>> getByStatusAndDeadlineDate(boolean status, Date deadlineDate);

	DataResult<List<JobPost>> getByStatusAndEmployer_CompanyName(boolean status, String companyName);
	
	Result add(JobPost jobPost);
}
