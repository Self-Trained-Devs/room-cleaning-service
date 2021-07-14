package com.roomcleaning.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomcleaning.model.CleanerRegistrationForm;
import com.roomcleaning.model.LoginModel;
import com.roomcleaning.model.UserRegistrationForm;
import com.roomcleaning.repository.CleanerRepository;

@Service
public class CleanerService {
	@Autowired
	private CleanerRepository cleanerRepository;
	
	public void saveCleaner(CleanerRegistrationForm cleaner) {
		cleanerRepository.save(cleaner);
	}
	
	public boolean validateCleanerCredentials(LoginModel loginModel) {
		List<CleanerRegistrationForm> users = new ArrayList<>();
		cleanerRepository.findAll().forEach(users::add);
		Iterator itr = users.iterator();
		while(itr.hasNext()) {
			CleanerRegistrationForm user = (CleanerRegistrationForm) itr.next();
			if(user.getCleanerId().contentEquals(loginModel.getUserId()) 
					&& user.getPassword().contentEquals(loginModel.getPassword()) 
					&& user.getCleanerRegistrationStatus().contentEquals("R"))
				return true;
		}
		return false;
	}
	
	public CleanerRegistrationForm getCLeaner(LoginModel loginModel) {
		List<CleanerRegistrationForm> users = new ArrayList<>();
		cleanerRepository.findAll().forEach(users::add);
		Iterator itr = users.iterator();
		while(itr.hasNext()) {
			CleanerRegistrationForm user = (CleanerRegistrationForm) itr.next();
			if(user.getCleanerId().contentEquals(loginModel.getUserId()) 
					&& user.getPassword().contentEquals(loginModel.getPassword()))
				return user;
		}
		return null;
	}
	
	public List<CleanerRegistrationForm> getAllCleanerRegistrationList(){
		List<CleanerRegistrationForm> cleanersList = new ArrayList<>();
		cleanerRepository.findAll().forEach(cleanersList::add);
		return cleanersList;
	}
	
	public List<CleanerRegistrationForm> getPendingCleanerRegistrationList(){
		List<CleanerRegistrationForm> cleanersList = new ArrayList<>();
		cleanerRepository.findAll().forEach(cleanersList::add);
		List<CleanerRegistrationForm> pendingCleanerList = new ArrayList<>();
		Iterator itr = cleanersList.iterator();
		while(itr.hasNext()) {
			CleanerRegistrationForm cleaner = (CleanerRegistrationForm)itr.next();
			if(cleaner.getCleanerRegistrationStatus().contentEquals("U"))
				pendingCleanerList.add(cleaner);
		}
		return pendingCleanerList;
	}
	
	public List<CleanerRegistrationForm> getApprovedCleanerRegistrationList(){
		List<CleanerRegistrationForm> cleanersList = new ArrayList<>();
		cleanerRepository.findAll().forEach(cleanersList::add);
		List<CleanerRegistrationForm> approvedCleanerList = new ArrayList<>();
		Iterator itr = cleanersList.iterator();
		while(itr.hasNext()) {
			CleanerRegistrationForm cleaner = (CleanerRegistrationForm)itr.next();
			if(cleaner.getCleanerRegistrationStatus().contentEquals("R"))
				approvedCleanerList.add(cleaner);
		}
		return approvedCleanerList;
	}
	
	public CleanerRegistrationForm getCLeanerByCleanerId(String cleanerId) {
		List<CleanerRegistrationForm> users = new ArrayList<>();
		cleanerRepository.findAll().forEach(users::add);
		Iterator itr = users.iterator();
		while(itr.hasNext()) {
			CleanerRegistrationForm user = (CleanerRegistrationForm) itr.next();
			if(user.getCleanerId().contentEquals(cleanerId))
				return user;
		}
		return null;
	}
	
	public boolean approveCleaner(String cleanerId) {
		CleanerRegistrationForm cleaner = getCLeanerByCleanerId(cleanerId);
		cleaner.setCleanerRegistrationStatus("R");
		cleanerRepository.save(cleaner);
		return false;
	}
}
