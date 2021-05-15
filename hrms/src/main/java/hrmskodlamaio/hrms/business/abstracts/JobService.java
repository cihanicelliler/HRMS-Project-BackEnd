package hrmskodlamaio.hrms.business.abstracts;

import java.util.List;

import hrmskodlamaio.hrms.entities.concretes.Job;

public interface JobService {
	List<Job> GetAll();
}
