package com.example.S13SpringBootREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.S13SpringBootREST.entity.User;

import com.example.S13SpringBootREST.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserWebController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping
	public String getUsers(ModelMap model) {
		model.addAttribute("users",repo.findAll());
		System.out.println(model);
		return "users";
	}
	
	@PostMapping
	public String adduser(@ModelAttribute("users") User users, ModelMap model) {
		repo.save(users);
		model.addAttribute("users",repo.findAll());
		return "display";
	}
	

}
