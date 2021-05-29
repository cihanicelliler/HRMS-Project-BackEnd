package hrmskodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmskodlamaio.hrms.entities.concretes.JobPost;

public interface JobPostDao extends JpaRepository<JobPost, Integer>{

	List<JobPost> getByStatus(boolean status);
	
	List<JobPost> getByStatusAndReleaseDate(boolean status, Date releaseDate);
	
	List<JobPost> getByStatusAndDeadlineDate(boolean status, Date deadlineDate);
	
	List<JobPost> getByStatusAndEmployer_CompanyName(boolean status, String companyName);
}
