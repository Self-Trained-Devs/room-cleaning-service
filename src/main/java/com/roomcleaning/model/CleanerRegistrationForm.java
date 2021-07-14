package com.roomcleaning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cleaner_details")
public class CleanerRegistrationForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cleanerRegisterId;
	private String cleanerId;
	private String password;
	@Transient
	private String verifyPassword;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String Gender;
	private String phoneNumber;
	private String cleanerRegistrationStatus;

	public String getCleanerRegistrationStatus() {
		return cleanerRegistrationStatus;
	}

	public void setCleanerRegistrationStatus(String cleanerRegistrationStatus) {
		this.cleanerRegistrationStatus = cleanerRegistrationStatus;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public int getCleanerRegisterId() {
		return cleanerRegisterId;
	}

	public void setCleanerRegisterId(int cleanerRegisterId) {
		this.cleanerRegisterId = cleanerRegisterId;
	}

	public String getCleanerId() {
		return cleanerId;
	}

	public void setCleanerId(String cleanerId) {
		this.cleanerId = cleanerId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CleanerRegistrationForm [cleanerRegisterId=" + cleanerRegisterId + ", cleanerId=" + cleanerId
				+ ", password=" + password + ", verifyPassword=" + verifyPassword + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", Gender=" + Gender + ", phoneNumber="
				+ phoneNumber + ", cleanerRegistrationStatus=" + cleanerRegistrationStatus + "]";
	}

}
