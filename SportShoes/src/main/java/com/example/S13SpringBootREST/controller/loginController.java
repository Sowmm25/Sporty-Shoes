package com.example.S13SpringBootREST.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.S13SpringBootREST.entity.User;
import com.example.S13SpringBootREST.entity.userinfo;
import com.example.S13SpringBootREST.repository.UserRepository;
import com.example.S13SpringBootREST.repository.loginRepository;
import com.example.S13SpringBootREST.repository.userinfoRepository;
import com.example.S13SpringBootREST.repository.userinfologRepository;
@Controller
public class loginController {
	

	@Autowired
	private loginRepository userRepo;
	@Autowired
	private userinfoRepository repo;
	@Autowired 
	private userinfologRepository rep;
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request,@RequestParam String username,@RequestParam String password) {
		User user=userRepo.findByUsernameAndPassword(username,password);
	    int id=userRepo.findIdByName(username);
	    userinfo u=new userinfo();
	    HttpSession session=request.getSession();
		if(user!=null) {
			u.setId(id);
			u.setLogtime(LocalDateTime.now());
			repo.save(u);
			session.setAttribute("username", username);
			System.out.println(username);
			System.out.println(session.getAttribute("username"));
			
			
			return "redirect:/display";
		}else {
			return "login";
		}
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	

}
