package com.learning.restservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "User_Name", length = 50, nullable = false, unique = true)
	private String username;
	
	@Column(name="F_NAME", length = 50,nullable = false)
	private String firstName;
	@Column(name="L_NAME", length = 50,nullable = false)
	private String lastName;
	@Column(name="EMAIL", length = 50,nullable = false)
	private String email;
	@Column(name="ROLE", length = 50,nullable = false)
	private String role;
	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	private String ssn;
	
	//no argument constructor 
	public User() {

		
	}

	//fileds constructor
	public User(Long id, String username, String firstName, String lastName, String email, String role, String ssn) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	//Getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	//optional to string required for bean logging 
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
