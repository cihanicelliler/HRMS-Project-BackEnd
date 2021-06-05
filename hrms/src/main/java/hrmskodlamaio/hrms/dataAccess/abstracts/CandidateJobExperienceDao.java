package hrmskodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmskodlamaio.hrms.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceDao extends JpaRepository<CandidateJobExperience, Integer>{

	List<CandidateJobExperience> findAllByCandidateCvIdOrderByYearOfLeavingDesc(int id);
}
