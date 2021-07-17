package com.roomcleaning.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roomcleaning.model.BookService;
import com.roomcleaning.model.CleanerRegistrationForm;
import com.roomcleaning.model.LoginModel;
import com.roomcleaning.service.AdminService;
import com.roomcleaning.service.BookServiceService;
import com.roomcleaning.service.CleanerService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private CleanerService cleanerService;
	@Autowired
	private BookServiceService bookServiceService;

	@RequestMapping(value = "/admin-login-form")
	public String userLogin(@ModelAttribute("loginModel") LoginModel loginModel) {
		return "adminLogin";
	}

	@RequestMapping(value = "/admin-login-validate", method = RequestMethod.POST)
	public String userLoginValidate(@ModelAttribute("loginModel") LoginModel loginModel, Model model) {
		LoginModel login = adminService.getAdminCredentials(loginModel);
		if (login != null) {
			model.addAttribute("userName", loginModel.getUserId() + "!");
			if (adminService.validateAdminCredentials(loginModel)) {
				model.addAttribute("isValidUser", true);
				model.addAttribute("validUser", " Logged in successfully");

				List<CleanerRegistrationForm> allCleanerRegistrationList = cleanerService
						.getAllCleanerRegistrationList();
				if (!(allCleanerRegistrationList.isEmpty())) {
					model.addAttribute("allCleaner", true);
					model.addAttribute("allCleanerRegistrationList", allCleanerRegistrationList);
					return "adminSuccess";
				}
				model.addAttribute("isListEmpty", true);
				model.addAttribute("emptyList", "Cleaners list is empty");
				return "adminSuccess";
			}
			model.addAttribute("inValidUser", true);
			model.addAttribute("invalidUser", " you have Entered Invalid Credentials");
			return "adminLogin";
		}
		model.addAttribute("inValidUser", true);
		model.addAttribute("userName", loginModel.getUserId());
		model.addAttribute("invalidUser", "Invalid Credentials");
		return "adminLogin";
	}

	@RequestMapping(value = "/all-cleaners-list")
	public String allCleanerList(Model model) {
		List<CleanerRegistrationForm> allCleanerRegistrationList = cleanerService.getAllCleanerRegistrationList();
		if (!(allCleanerRegistrationList.isEmpty())) {
			model.addAttribute("allCleaner", true);
			model.addAttribute("allCleanerRegistrationList", allCleanerRegistrationList);
			return "adminSuccess";
		}
		model.addAttribute("isListEmpty", true);
		model.addAttribute("emptyList", "Cleaners list is empty");
		return "adminSuccess";
	}

	@RequestMapping(value = "/approved-cleaners-list")
	public String approvedCleanerList(Model model) {
		List<CleanerRegistrationForm> approvedCleanerRegistrationList = cleanerService
				.getApprovedCleanerRegistrationList();
		if (!(approvedCleanerRegistrationList.isEmpty())) {
			model.addAttribute("approvedCleaner", true);
			model.addAttribute("approvedCleanerRegistrationList", approvedCleanerRegistrationList);
			return "adminSuccess";
		}
		model.addAttribute("isListEmpty", true);
		model.addAttribute("emptyList", "Cleaners list is empty");
		return "adminSuccess";
	}

	@RequestMapping(value = "/pending-cleaners-list")
	public String pendingCleanerList(Model model) {
		List<CleanerRegistrationForm> pendingCleanerRegistrationList = cleanerService
				.getPendingCleanerRegistrationList();
		if (!(pendingCleanerRegistrationList.isEmpty())) {
			model.addAttribute("pendingCleaner", true);
			model.addAttribute("pendinCleanerRegistrationList", pendingCleanerRegistrationList);
			return "adminSuccess";
		}
		model.addAttribute("isListEmpty", true);
		model.addAttribute("emptyList", "Nothing to approve here!...");
		return "adminSuccess";
	}

	@RequestMapping(value = "/approve-cleaner")
	public String approveCleaner(@RequestParam("cleanerId") String cleanerId, Model model) {
		boolean isApproved = cleanerService.approveCleaner(cleanerId);
		List<CleanerRegistrationForm> pendingCleanerRegistrationList = cleanerService
				.getPendingCleanerRegistrationList();
		if (!(pendingCleanerRegistrationList.isEmpty())) {
			model.addAttribute("pendingCleaner", true);
			model.addAttribute("pendinCleanerRegistrationList", pendingCleanerRegistrationList);
			return "adminSuccess";
		}
		model.addAttribute("isListEmpty", true);
		model.addAttribute("emptyList", "Cleaners list is empty");
		return "adminSuccess";
	}
	
	@RequestMapping(value="/admin-logout")
	public String cleanerLogout() {
		return "redirect:/admin-login-form";
	}
	
	@RequestMapping(value="/booked-services")
	public String bookedServices(Model model) {
		List<BookService> allBookServiceForAdmin = bookServiceService.getAllBookServiceForAdmin();
		if(!allBookServiceForAdmin.isEmpty()) {
			model.addAttribute("allBookServiceList", allBookServiceForAdmin);
			model.addAttribute("isAllServiceList", true);
			return "adminSuccess";
		}
		model.addAttribute("allServiceList", true);
		return "adminSuccess";
	}
	
	@RequestMapping(value="/booking-service-in-detailed-admin")
	public String bookingServiceInDetailed(@RequestParam("serviceId") int serviceId, Model model) {
		Optional<BookService> bookServiceById = bookServiceService.getBookServiceById(serviceId);
		BookService bookService = new BookService();
		bookService = bookServiceById.get();
		model.addAttribute("serviceId", serviceId);
		model.addAttribute("assignCleaner", bookService);
		model.addAttribute("isBookingDetailedStatus", true);
		if(bookService.getCleanerId() ==null || bookService.getCleanerId().isEmpty()) {
		model.addAttribute("notAssigned", true);
		model.addAttribute("bookService", bookService);
		return "adminSuccess";
		}
		model.addAttribute("bookService", bookService);
		model.addAttribute("isAssigned", true);
		model.addAttribute("isCleanerAssigned", true);
		return "adminSuccess";
	} 
	
	@RequestMapping("/assignCleaner")
	public String assignCleaner(@RequestParam("serviceId") int serviceId,
			@ModelAttribute("assignCleaner") BookService bookservice, 
			Model model) {
		Optional<BookService> bookServiceById = bookServiceService.getBookServiceById(serviceId);
		BookService bookService = new BookService();
		bookService = bookServiceById.get();
		if(bookService.getCleanerId() ==null || bookService.getCleanerId().isEmpty())
		bookService.setCleanerId(bookservice.getCleanerId());
		bookServiceService.saveBookService(bookService);
		model.addAttribute("isBookingDetailedStatus", true);
		model.addAttribute("serviceId", serviceId);
		model.addAttribute("bookService", bookService);
		model.addAttribute("isCleanerAssigned", true);
		model.addAttribute("isAssigned", true);
		return "adminSuccess";
	}
	
	@ModelAttribute("cleanerList")
	public Map<String,String> getCleanerList(){
		Map<String,String> cleanerList= new TreeMap<>();
		List<CleanerRegistrationForm> allCleanerRegistrationList = cleanerService.getAllCleanerRegistrationList();
		if(!allCleanerRegistrationList.isEmpty()) {
			for(CleanerRegistrationForm cleanerlist : allCleanerRegistrationList) {
				cleanerList.put(cleanerlist.getCleanerId(), cleanerlist.getCleanerId());
			}
		}
		return cleanerList;
	}
}
