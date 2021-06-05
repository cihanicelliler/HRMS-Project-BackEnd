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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates_job_expreiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class CandidateJobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_expreince_id")
	private int jobExpreinceId;
	
	@Column(name="company_name")
	private String companyName;
	
	@OneToOne()
	@JoinColumn(name="position_id",referencedColumnName = "id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name = "candidate_cv_id")
	@JsonIgnoreProperties({"candidateImage","candidateSchool","candidateLanguage","candidateTechnology","candidateJobExperience"})
	private CandidateCv candidateCv;
	
	@Column(name="year_of_employment")
	private Date yearOfEmployment;
	
	@Column(name="year_of_leaving")
	private Date yearOfLeaving;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;
}
