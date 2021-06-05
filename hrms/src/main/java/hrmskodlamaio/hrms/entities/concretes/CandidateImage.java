package hrmskodlamaio.hrms.entities.concretes;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates_images")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class CandidateImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int imageId;
	
	@Column(name="image_path")
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name = "candidate_cv_id")
	@JsonIgnoreProperties({"candidateImage","candidateSchool","candidateLanguage","candidateTechnology","candidateJobExperience"})
	private CandidateCv candidateCv;
}
