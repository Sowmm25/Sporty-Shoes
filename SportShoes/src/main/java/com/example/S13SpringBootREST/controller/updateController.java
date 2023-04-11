package com.example.S13SpringBootREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.S13SpringBootREST.entity.adminUser;
import com.example.S13SpringBootREST.repository.updatePasswordRepository;
@Controller
public class updateController {
	@Autowired
	private updatePasswordRepository repo;
	@GetMapping("/update")
	private String adminlogin() {
		return "update";
	}
	@PostMapping("/update")
	public String update(@RequestParam String username,@RequestParam String password) {
		adminUser user=repo.findByUsername(username);
		if(user!=null) {
			user.setPassword(password);
			repo.save(user);
			return "update";
		}else {
			return "adminlogin";
		}
		
	}

}
