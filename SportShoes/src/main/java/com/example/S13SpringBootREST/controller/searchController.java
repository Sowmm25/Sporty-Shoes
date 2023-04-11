package com.example.S13SpringBootREST.controller;

import org.hibernate.result.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.S13SpringBootREST.repository.UserRepository;

@Controller
public class searchController {
	@Autowired
	private UserRepository repo;
	@PostMapping("/search")
	public String search(@RequestParam String username,Model model) {
		int i=repo.findIdByName(username);
		//String s=repo.findByUsername(username);
		System.out.println(i);
		//if(s==null) {
		//	return "search";
		//}
		model.addAttribute("result",i);
		return "searchresult";
		
	
			
		}
		
		
	}



