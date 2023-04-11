package com.example.S13SpringBootREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.S13SpringBootREST.entity.Product;
import com.example.S13SpringBootREST.entity.adminUser;
import com.example.S13SpringBootREST.repository.ProductRepository;
import com.example.S13SpringBootREST.repository.updatePasswordRepository;

@Controller
public class updateproducts {
	@Autowired
	private ProductRepository repo;
	@GetMapping("/updateproducts")
	private String adminlogin() {
		return "updateproducts";
	}

	@RequestMapping(value="/updateproducts",params = "update", method = RequestMethod.POST)
	public String update(@RequestParam String name,@RequestParam String description,@RequestParam double price,@RequestParam int id) {
		Product product=repo.findById(id);
		if(product!=null) {
			product.setPrice(price);
			product.setProduct_description(description);
			product.setProduct_name(name);
			repo.save(product);
			return "updateproducts";
		}else {
			return "adminlogin";
		}
		
	}
	@RequestMapping(value="/updateproducts",params = "delete", method = RequestMethod.POST)
	public String delete(@RequestParam int id) {
		Product product=repo.findById(id);
		if(product!=null) {
			repo.delete(product);
			return "updateproducts";
		}else {
			return "adminlogin";
		}
		
	}
	

}
