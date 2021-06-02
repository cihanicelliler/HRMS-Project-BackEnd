package hrmskodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates_technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class CandidateTechnology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="technologie_id")
	private int techonologieId;
	
	@Column(name="technologie_name")
	private String technologieName;
	
	@Column(name="programming_language")
	private String programmingLanguage;
	
	@OneToMany(mappedBy = "candidateTechnology")
	private List<CandidateCv> candidateCv;
}
