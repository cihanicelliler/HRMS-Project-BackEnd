package hrmskodlamaio.hrms.entities.concretes;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPosts"})
public class Employer{
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_name") 
	private String companyName;
	
	@Column(name="web_adress")
	private String webAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_activated")
	private boolean isActivated;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private User user;
	
	@OneToMany(mappedBy = "employer")
	private List<JobPost> jobPosts;

	public Employer(int userId, String companyName, String webAdress, String phoneNumber, boolean isActivated) {
		this.userId = userId;
		this.companyName = companyName;
		this.webAdress = webAdress;
		this.phoneNumber = phoneNumber;
		this.isActivated = isActivated;
	}
	
	
}
