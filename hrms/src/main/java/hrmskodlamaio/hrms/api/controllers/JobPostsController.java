package hrmskodlamaio.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmskodlamaio.hrms.business.abstracts.JobPostService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.JobPost;

@RestController
@RequestMapping("/api/jobposts")
public class JobPostsController {

	private JobPostService jobPostService;

	public JobPostsController(JobPostService jobPostService) {
		super();
		this.jobPostService = jobPostService;
	}
	
	@GetMapping("/getallactive")
	public DataResult<List<JobPost>> getByStatus() {
		return this.jobPostService.getByStatus(true);
		
	}
	
	@GetMapping("/getAllWithReleaseDate")
	public DataResult<List<JobPost>> getByStatusAndReleaseDate(Date releaseDate) {
		return this.jobPostService.getByStatusAndReleaseDate(true, releaseDate);
	}
	
	@GetMapping("/getAllWithDeadlineDate")
	public DataResult<List<JobPost>> getByStatusAndDeadlineDate(Date deadlineDate) {
		return this.jobPostService.getByStatusAndDeadlineDate(true, deadlineDate);
	}
	
	@GetMapping("/getAllWithCompanyName")
	public DataResult<List<JobPost>> getByStatusAndEmployer_CompanyName(String companyName) {
		return this.jobPostService.getByStatusAndEmployer_CompanyName(true, companyName);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPost jobPost){
		return this.jobPostService.add(jobPost);
	}
}
