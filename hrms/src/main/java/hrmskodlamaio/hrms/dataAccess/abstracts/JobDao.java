package hrmskodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmskodlamaio.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job,Integer>{
	Job findByTitle(String title);
}
