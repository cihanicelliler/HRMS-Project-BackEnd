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
@Table(name="candidates_schools")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class CandidateSchool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private int schoolId;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="start_year")
	private Date startYear;
	
	@Column(name="graduation_year")
	private Date graduationYear;
	
	@Column(name="class_degree")
	private int classDegree;
	
	@Column(name="class_license")
	private String classLicense;
	
	@Column(name="class_path")
	private String classPath;
	
	@ManyToOne
	@JoinColumn(name = "candidate_cv_id")
	@JsonIgnoreProperties({"candidateImage","candidateSchool","candidateLanguage","candidateTechnology","candidateJobExperience"})
	private CandidateCv candidateCv;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;
}
