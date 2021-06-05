package hrmskodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmskodlamaio.hrms.entities.concretes.CandidateSchool;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer>{
	List<CandidateSchool> findAllByCandidateCvIdOrderByGraduationYearDesc(int id);
}
