package com.roomcleaning.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roomcleaning.model.BookService;
import com.roomcleaning.model.LoginModel;
import com.roomcleaning.model.UserRegistrationForm;
import com.roomcleaning.service.BookServiceService;
import com.roomcleaning.service.UserService;
import com.roomcleaning.validator.BookServiceFormValidator;
import com.roomcleaning.validator.UserRegistrationFormValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRegistrationFormValidator userValidator;
	@Autowired
	HttpSession session;
	@Autowired
	private BookServiceFormValidator bookServiceFormValidator;
	@Autowired
	private BookServiceService bookServiceService;
	
	@RequestMapping("/user-register")
	public String registrationForm(Model model) {
		model.addAttribute("registration", new UserRegistrationForm());
		return "userRegistrationForm";

	}

	@RequestMapping(value = "/user-register", method = RequestMethod.POST)
	public String registerFormToDb(@ModelAttribute("registration") UserRegistrationForm registration,
			BindingResult errors, Model model) {
		userValidator.validate(registration, errors);
		if (errors.hasErrors())
			return "userRegistrationForm";
		userService.saveUser(registration);
		model.addAttribute("isUserCreated", true);
		model.addAttribute("loginModel", new LoginModel());
		model.addAttribute("userCreatedMessage", "User Created Successfully");
		return "userLogin";
	}

	@RequestMapping(value = "/user-login-form")
	public String userLogin(@ModelAttribute("loginModel") LoginModel loginModel) {
		return "userLogin";
	}

	@RequestMapping(value = "/user-login-validate", method = RequestMethod.POST)
	public String userLoginValidate(@ModelAttribute("loginModel") LoginModel loginModel, Model model) {
		UserRegistrationForm user = userService.getUserCredentials(loginModel);
		if (user != null) {
			if (userService.validateUserCredentials(loginModel)) {
				session.setAttribute("userName", loginModel.getUserId());
				model.addAttribute("isValidUser", true);
				model.addAttribute("validUser", " Logged in successfully");
				return "userSuccess";
			}
			model.addAttribute("inValidUser", true);
			model.addAttribute("inValidUser", " you have Entered Invalid Credentials");
			return "userLogin";
		}
		model.addAttribute("inValidUser", true);
		model.addAttribute("userName", loginModel.getUserId());
		model.addAttribute("invalidUser", " Invalid Credentials");
		return "userLogin";
	}

	@RequestMapping(value = "/user-logout")
	public String cleanerLogout() {
		return "redirect:/user-login-form";
	}
	
	@RequestMapping(value="/book-service")
	public String bookService(@ModelAttribute("bookService") BookService bookSerice, Model model) {
		model.addAttribute("isBookService", true);
		return "userSuccess";
	}
	
	@RequestMapping(value="/book-service", method=RequestMethod.POST)
	public String postbookServiceClick(@ModelAttribute("bookService") BookService bookSerice, 
			Model model, BindingResult errors) {
		bookServiceFormValidator.validate(bookSerice, errors);
		if(!errors.hasErrors()) {
			bookServiceService.saveBookService(bookSerice);
			model.addAttribute("isBooked", true);
			model.addAttribute("BookedMessage", "Successfully Booked! Your service Id : " + bookSerice.getServiceId());
			model.addAttribute("isBookService", true);
			model.addAttribute("bookService", new BookService());
			return "userSuccess";
		}
		model.addAttribute("isBookService", true);
		return "userSuccess";
	}
	
	@RequestMapping(value="/booking-status")
	public String bookingStatus(Model model) {
		String userName = (String) session.getAttribute("userName");
		List<BookService> allBookService = bookServiceService.getAllBookService(userName);
		model.addAttribute("bookServiceList", allBookService);
		model.addAttribute("isBookingStatus", true);
		return "userSuccess";
	}
	
	@RequestMapping(value="/booking-service-in-detailed")
	public String bookingServiceInDetailed(@RequestParam("serviceId") int serviceId, Model model) {
		Optional<BookService> bookServiceById = bookServiceService.getBookServiceById(serviceId);
		BookService bookService = new BookService();
		bookService = bookServiceById.get();
		model.addAttribute("bookService", bookService);
		model.addAttribute("isBookingDetailedStatus", true);
		return "userSuccess";
	}
}
