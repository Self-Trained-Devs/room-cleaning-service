package com.roomcleaning.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomcleaning.model.LoginModel;
import com.roomcleaning.model.UserRegistrationForm;
import com.roomcleaning.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public void saveUser(UserRegistrationForm user) {
		repository.save(user);
	}
	
	public boolean validateUserCredentials(LoginModel loginModel) {
		List<UserRegistrationForm> users = new ArrayList<>();
		repository.findAll().forEach(users::add);
		Iterator itr = users.iterator();
		while(itr.hasNext()) {
			UserRegistrationForm user = (UserRegistrationForm) itr.next();
			if(user.getUserId().contentEquals(loginModel.getUserId()) 
					&& user.getPassword().contentEquals(loginModel.getPassword()))
				return true;
		}
		return false;
	}
	
	public UserRegistrationForm getUserCredentials(LoginModel loginModel) {
		List<UserRegistrationForm> users = new ArrayList<>();
		repository.findAll().forEach(users::add);
		Iterator itr = users.iterator();
		while(itr.hasNext()) {
			UserRegistrationForm user = (UserRegistrationForm) itr.next();
			if(user.getUserId().contentEquals(loginModel.getUserId()) 
					&& user.getPassword().contentEquals(loginModel.getPassword()))
				return user;
		}
		return null;
	}
}
