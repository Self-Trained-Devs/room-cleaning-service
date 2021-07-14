package com.roomcleaning.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user_details")
public class UserRegistrationForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userRegisterId;
	private String userId;
	private String password;
	@Transient
	private String verifyPassword;

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String Gender;

	public int getUserRegisterId() {
		return userRegisterId;
	}

	public void setUserRegisterId(int userRegisterId) {
		this.userRegisterId = userRegisterId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "RegistrationForm [userRegisterId=" + userRegisterId + ", userId=" + userId + ", password=" + password
				+ ", verifyPassword=" + verifyPassword + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", Gender=" + Gender + "]";
	}

}
