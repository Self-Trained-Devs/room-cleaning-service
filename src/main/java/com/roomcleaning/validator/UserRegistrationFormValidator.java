package com.roomcleaning.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.roomcleaning.model.UserRegistrationForm;

@Service
public class UserRegistrationFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors error) {
		UserRegistrationForm userForm = (UserRegistrationForm) arg0;
		String pass = userForm.getPassword();
		if(userForm.getFirstName().isEmpty())
			error.rejectValue("firstName", "", "First Name Cannot be Empty");
		if(userForm.getLastName().isEmpty())
			error.rejectValue("lastName", "", "Last Name Cannot be Empty");
		if(userForm.getDateOfBirth().isEmpty())
			error.rejectValue("dateOfBirth", "", "Date of Birth should be selected");
		if(userForm.getGender() == null)
			error.rejectValue("gender", "", "Gender should be selected");
		if(userForm.getUserId().isEmpty())
			error.rejectValue("userId", "", "User ID cannot be Empty");
		if(userForm.getUserId().length()<8)
			error.rejectValue("userId", "", "User ID should be 8 or more characcters");
		if(userForm.getPassword().isEmpty())
			error.rejectValue("password", "", "Password cannot be empty");
		if(userForm.getVerifyPassword().isEmpty())
			error.rejectValue("verifyPassword", "", "Re-Enter Password cannot be empty");
		if(!(userForm.getVerifyPassword().matches(pass)))
			error.rejectValue("verifyPassword", "", "Re-Enter password should match with password");
	}

}
