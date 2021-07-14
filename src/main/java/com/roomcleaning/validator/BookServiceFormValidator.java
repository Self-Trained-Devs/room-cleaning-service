package com.roomcleaning.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.roomcleaning.model.BookService;
import com.roomcleaning.model.CleanerRegistrationForm;
import com.roomcleaning.model.UserRegistrationForm;

@Service
public class BookServiceFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors error) {
		BookService bookService = (BookService) arg0;
		String pattern="[789]{1}[0-9]{9}";
		if (bookService.getRoomCount().isEmpty())
			error.rejectValue("roomCount", "", "roomCount Cannot be Empty");
		if (!bookService.getRoomCount().isEmpty()) {
			if (Integer.parseInt(bookService.getRoomCount()) <= 0)
				error.rejectValue("roomCount", "", "roomCount Cannot be Zero or less");
		}
		if (bookService.getAddress().isEmpty())
			error.rejectValue("address", "", "Address Cannot be Empty");
		if (bookService.getPinCode().length() != 6)
			error.rejectValue("pinCode", "", "Please Enter Valid pin code");
		// if(Integer.parseInt(bookService.getPinCode())<000000 &&
		// Integer.parseInt(bookService.getPinCode())>999999)
		// error.rejectValue("pinCode", "", "Please Enter Valid pin code");
		if (bookService.getFromTime().isEmpty())
			error.rejectValue("fromTime", "", "From Time should be selected");
		if (bookService.getToTime().isEmpty())
			error.rejectValue("toTime", "", "To Time should be selected");
		if(!bookService.getContactNumber().isEmpty()) {
			if(!(bookService.getContactNumber().matches(pattern)))
				error.rejectValue("contactNumber", "", "Please Enter Valid Number");
		}
	}

	public boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++)
			if (Character.isDigit(s.charAt(i)) == false)
				return false;

		return true;
	}

}
