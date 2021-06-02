package hrmskodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates_cv")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate  candidate;
	
	@ManyToOne()
	@JoinColumn(name="candidate_school_id")
	private CandidateSchool candidateSchool;
	
	@ManyToOne()
	@JoinColumn(name="candidate_language_id")
	private CandidateLanguage candidateLanguage;
	
	@ManyToOne()
	@JoinColumn(name="candidate_technologie_id")
	private CandidateTechnology candidateTechnology;
	
	@ManyToOne()
	@JoinColumn(name="candidate_job_experience_id")
	private CandidateJobExperience candidateJobExperience;
	
	@ManyToOne()
	@JoinColumn(name="candidate_image_id")
	private CandidateImage candidateImage;
	
	@Column(name="github_address")
	private String githubAddress;
	
	@Column(name="linkedin_address")
	private String linkedinAddress;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
}
