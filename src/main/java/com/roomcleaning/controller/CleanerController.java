package com.roomcleaning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roomcleaning.model.CleanerRegistrationForm;
import com.roomcleaning.model.LoginModel;
import com.roomcleaning.model.UserRegistrationForm;
import com.roomcleaning.service.CleanerService;
import com.roomcleaning.validator.CleanerRegistrationFormValidator;

@Controller
public class CleanerController {

	@Autowired
	private CleanerService cleanerService;
	@Autowired
	private CleanerRegistrationFormValidator cleanerValidator;

	@RequestMapping("/cleaner-register")
	public String registrationForm(Model model) {
		model.addAttribute("registration", new CleanerRegistrationForm());
		return "cleanerRegistrationForm";

	}

	@RequestMapping(value = "/cleaner-register", method = RequestMethod.POST)
	public String registerFormToDb(@ModelAttribute("registration") CleanerRegistrationForm registration,
			BindingResult errors, Model model) {
		cleanerValidator.validate(registration, errors);
		if (errors.hasErrors())
			return "cleanerRegistrationForm";
		registration.setCleanerRegistrationStatus("U");
		cleanerService.saveCleaner(registration);
		model.addAttribute("isUserCreated", true);
		model.addAttribute("loginModel", new LoginModel());
		model.addAttribute("userCreatedMessage", "Cleaner Created Successfully");
		return "cleanerLogin";
	}

	@RequestMapping(value = "/cleaner-login-form")
	public String cleanerLogin(@ModelAttribute("loginModel") LoginModel loginModel) {
		return "cleanerLogin";
	}

	@RequestMapping(value = "/cleaner-login-validate", method = RequestMethod.POST)
	public String userLoginValidate(@ModelAttribute("loginModel") LoginModel loginModel, Model model) {
		CleanerRegistrationForm user = cleanerService.getCLeaner(loginModel);
		if (user != null) {
			model.addAttribute("userName", loginModel.getUserId() + "!");
			if (user.getCleanerRegistrationStatus().contentEquals("U")) {
				model.addAttribute("inValidUser", true);
				model.addAttribute("invalidUser", "Admin is yet to confirm your Eligibility");
				return "cleanerLogin";
			}
			if (cleanerService.validateCleanerCredentials(loginModel)) {
				model.addAttribute("isValidUser", true);
				model.addAttribute("validUser", " Logged in successfully");
				return "cleanerSuccess";
			}
			model.addAttribute("inValidUser", true);
			model.addAttribute("invalidUser", " you have entered Invalid Credentials");
			return "cleanerLogin";
		}
		model.addAttribute("userName", loginModel.getUserId());
		model.addAttribute("inValidUser", true);
		model.addAttribute("invalidUser", "Invalid Credentials");
		return "cleanerLogin";
	}
	
	@RequestMapping(value="/cleaner-logout")
	public String cleanerLogout() {
		return "redirect:/cleaner-login-form";
	}
}
