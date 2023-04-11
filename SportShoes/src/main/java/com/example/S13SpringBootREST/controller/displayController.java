package com.example.S13SpringBootREST.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.S13SpringBootREST.entity.Purchase;
import com.example.S13SpringBootREST.repository.UserRepository;
import com.example.S13SpringBootREST.repository.purchaseRepository;

@Controller
public class displayController {
	@Autowired
	private UserRepository repo;
	@Autowired
	private purchaseRepository prepo;
  @GetMapping("/display")
  public String display(HttpServletRequest request,Model model) {
	  HttpSession session=request.getSession();
	  String username=(String)session.getAttribute("username");
	  System.out.println(username);
	  model.addAttribute("username",username);
	 
	  return "display";
  }
 @PostMapping("/display")
  public String display1(HttpServletRequest request,Model model,@RequestParam String size,@RequestParam(value="id", required = false) String id) {
	  HttpSession session=request.getSession();
	  String username=(String)session.getAttribute("username");
	  System.out.println(username);
	  model.addAttribute("username",username);
	  Purchase purchase=new Purchase();
	  int i=repo.findIdByName(username);
	  purchase.setId(i);
	  int id1=Integer.parseInt(id);
	  System.out.println(id);
	  System.out.println(size);
	  purchase.setProduct_id(id1);
	  
	  purchase.setSize(size);
	  prepo.save(purchase);
	  return "display";
  }
  
  
}
