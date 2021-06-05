package hrmskodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmskodlamaio.hrms.entities.concretes.CandidateTechnology;

public interface CandidateTechnologyDao extends JpaRepository<CandidateTechnology, Integer>{

}
