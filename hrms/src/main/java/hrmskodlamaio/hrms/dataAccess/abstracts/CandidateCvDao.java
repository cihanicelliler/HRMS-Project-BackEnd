package hrmskodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrmskodlamaio.hrms.entities.concretes.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{
		List<CandidateCv> findAllByCandidateUserId(int Id);
	}
