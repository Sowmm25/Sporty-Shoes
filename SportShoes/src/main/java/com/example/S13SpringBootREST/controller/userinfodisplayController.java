package com.example.S13SpringBootREST.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userinfodisplayController {

	@GetMapping("/userinfodisplay")
	private String adminlogin() {
		return "userinfodisplay";
	}
}
