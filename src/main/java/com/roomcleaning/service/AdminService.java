package com.roomcleaning.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomcleaning.model.CleanerRegistrationForm;
import com.roomcleaning.model.LoginModel;
import com.roomcleaning.repository.CleanerRepository;

@Service
public class AdminService {
	@Autowired
	private CleanerRepository cleanerRepository;

	public boolean validateAdminCredentials(LoginModel loginModel) {
		if (loginModel.getUserId().equalsIgnoreCase("admin") && loginModel.getPassword().equalsIgnoreCase("admin"))
			return true;
		return false;
	}
	
	public LoginModel getAdminCredentials(LoginModel loginModel) {
		if (loginModel.getUserId().equalsIgnoreCase("admin") && loginModel.getPassword().equalsIgnoreCase("admin"))
			return loginModel;
		return null;
	}
	

}
