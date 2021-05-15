package hrmskodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="job_titles")
@Data
public class Job {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	public Job() {
		
	}
	public Job(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
}
