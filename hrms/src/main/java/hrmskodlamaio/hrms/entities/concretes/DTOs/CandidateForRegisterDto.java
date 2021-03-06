package hrmskodlamaio.hrms.entities.concretes.DTOs;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForRegisterDto {
	private String firstName;
	private String lastName;
	private String nationalityId;
	private Date dateOfBirth;
	private String email;
	private String password;
	private String verifyPassword;
}
