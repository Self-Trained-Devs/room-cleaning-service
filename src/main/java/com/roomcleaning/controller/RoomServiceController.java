package com.roomcleaning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomServiceController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
}
