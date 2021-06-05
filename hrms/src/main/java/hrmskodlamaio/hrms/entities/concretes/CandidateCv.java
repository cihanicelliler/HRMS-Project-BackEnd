package hrmskodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@JsonIgnoreProperties("candidateCv")
	private Candidate  candidate;
	
	@OneToMany(mappedBy = "candidateCv")
	@JsonIgnoreProperties("candidateCv")
	private List<CandidateSchool> candidateSchool;
	
	@OneToMany(mappedBy = "candidateCv")
	@JsonIgnoreProperties("candidateCv")
	private List<CandidateLanguage> candidateLanguage;
	
	@OneToMany(mappedBy = "candidateCv")
	@JsonIgnoreProperties("candidateCv")
	private List<CandidateTechnology> candidateTechnology;
	
	@OneToMany(mappedBy = "candidateCv")
	@JsonIgnoreProperties("candidateCv")
	private List<CandidateJobExperience> candidateJobExperience;
	
	@OneToMany(mappedBy = "candidateCv")
	@JsonIgnoreProperties("candidateCv")
	private List<CandidateImage> candidateImage;
	
	@Column(name="github_address")
	private String githubAddress;
	
	@Column(name="linkedin_address")
	private String linkedinAddress;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;
	
}
