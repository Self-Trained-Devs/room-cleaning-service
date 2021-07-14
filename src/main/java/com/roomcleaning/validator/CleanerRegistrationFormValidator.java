package com.roomcleaning.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.roomcleaning.model.CleanerRegistrationForm;
import com.roomcleaning.model.UserRegistrationForm;

@Service
public class CleanerRegistrationFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors error) {
		CleanerRegistrationForm cleanerUserForm = (CleanerRegistrationForm) arg0;
		String pass = cleanerUserForm.getPassword();
		if(cleanerUserForm.getFirstName().isEmpty())
			error.rejectValue("firstName", "", "First Name Cannot be Empty");
		if(cleanerUserForm.getLastName().isEmpty())
			error.rejectValue("lastName", "", "Last Name Cannot be Empty");
		if(cleanerUserForm.getDateOfBirth().isEmpty())
			error.rejectValue("dateOfBirth", "", "Date of Birth should be selected");
		if(cleanerUserForm.getGender() == null)
			error.rejectValue("gender", "", "Gender should be selected");
		if(cleanerUserForm.getCleanerId().isEmpty())
			error.rejectValue("cleanerId", "", "Cleaner ID cannot be Empty");
		if(cleanerUserForm.getPhoneNumber().isEmpty())
			error.rejectValue("phoneNumber", "", "Phone Number cannot be Empty");
		if(!(cleanerUserForm.getPhoneNumber().isEmpty())) {
		if(cleanerUserForm.getPhoneNumber().length() != 10)
			error.rejectValue("phoneNumber", "", "Phone Number Should have exact 10 numbers");
		}
		if(cleanerUserForm.getCleanerId().length()<8)
			error.rejectValue("cleanerId", "", "Cleaner ID should be 8 or more characcters");
		if(cleanerUserForm.getPassword().isEmpty())
			error.rejectValue("password", "", "Password cannot be empty");
		if(cleanerUserForm.getVerifyPassword().isEmpty())
			error.rejectValue("verifyPassword", "", "Re-Enter Password cannot be empty");
		if(!(cleanerUserForm.getVerifyPassword().matches(pass)))
			error.rejectValue("verifyPassword", "", "Re-Enter password should match with password");
	}

}
