package hrmskodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	

	@Column(name="mail_verified",nullable=false)
	private boolean emailVerified;

	@Column(name="mail_verify_code",nullable=false)
	private String emailVerifyCode;
	
	public User(String email, String password, boolean emailVerified, String emailVerifyCode) {
		this.email = email;
		this.password = password;
		this.emailVerified = emailVerified;
		this.emailVerifyCode = emailVerifyCode;
	}
	
}
