package hrmskodlamaio.hrms.entities.concretes;

import java.util.Date;

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
@Data
@Table(name = "job_posts")
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "country_id")
	private Country country;

	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private Job job;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "job_count")
	private int jobCount;

	@Column(name = "deadline_date")
	private Date deadlineDate;

	@Column(name = "release_date")
	private Date releaseDate;

	@Column(name = "min_salary",nullable = false)
	private int min_salary;

	@Column(name = "max_salary",nullable = false)
	private int max_salary;

	@Column(name = "status")
	private boolean status;

}
