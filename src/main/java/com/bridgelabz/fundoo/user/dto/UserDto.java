package com.bridgelabz.fundoo.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;


public class UserDto {

	@NotEmpty(message = "Firstname should not be blank")
	@Size(min = 3, message = "Firstname cannot be less than 3 character")
	private String firstname;

	@NotEmpty(message = "lastname should not be blank")
	@Size(min = 3, message = "lastname cannot be less than 3 character")
	private String lastname;

	
	@Email
	@NotEmpty(message = "email should not be blank")
	@Size(min = 10, max = 30, message = "email_id should  be greater than 10 character and less than 20 character")
	private String email;

	@NotEmpty(message = "Password should not be blank")
	@Size(min = 8, max = 20, message = "password should  be greater than 8 character and less than 20 character")
	private String password;

	public UserDto(@Size(min = 3, message = "Firstname cannot be less than 3 character") String firstname,
			@Size(min = 3, message = "lastname cannot be less than 3 character") String lastname,
			@Email @Size(min = 10, max = 20, message = "email_id should  be greater than 10 character and less than 20 character") String email,
			@Size(min = 8, max = 20, message = "password should  be greater than 8 character and less than 20 character") String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}
