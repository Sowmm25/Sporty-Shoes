package com.example.S13SpringBootREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.S13SpringBootREST.entity.User;
import com.example.S13SpringBootREST.entity.adminUser;
import com.example.S13SpringBootREST.repository.adminloginRepository;
@Controller
public class adloginController {
	@Autowired
	private adminloginRepository repo;
	@GetMapping("/adminlogin")
	private String adminlogin() {
		return "adminlogin";
	}
	@PostMapping("/adminlogin")
	public String login(@RequestParam String username,@RequestParam String password) {
		adminUser user=repo.findByUsernameAndPassword(username,password);
	
		if(user!=null) {
			return "adminsuccess";
		}else {
			return "adminlogin";
		}
	}

	
}
