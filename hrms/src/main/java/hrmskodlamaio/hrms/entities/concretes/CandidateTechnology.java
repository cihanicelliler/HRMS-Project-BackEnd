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
@Table(name="candidates_technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateTechnology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="technologie_id")
	private int techonologieId;
	
	@Column(name="technologie_name")
	private String technologieName;
	
	@Column(name="programming_language")
	private String programmingLanguage;
	
	@ManyToOne
	@JoinColumn(name = "candidate_cv_id")
	@JsonIgnoreProperties({"candidateImage","candidateSchool","candidateLanguage","candidateTechnology","candidateJobExperience"})
	private CandidateCv candidateCv;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;
}
