package hrmskodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmskodlamaio.hrms.entities.concretes.CandidateImage;

public interface CandidateImageDao extends JpaRepository<CandidateImage, Integer> {

}
