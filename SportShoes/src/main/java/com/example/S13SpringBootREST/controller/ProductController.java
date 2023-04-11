package com.example.S13SpringBootREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.S13SpringBootREST.entity.Product;
import com.example.S13SpringBootREST.repository.CategoryRepository;
import com.example.S13SpringBootREST.repository.ProductRepository;
import com.example.S13SpringBootREST.repository.UserRepository;

@Controller
public class ProductController {
	@Autowired
	private UserService service;
	@Autowired
	private CategoryRepository repo;
	@GetMapping("/products")
	private String adminlogin() {
		return "products";
	}
	
	@PostMapping("/products")
	public ResponseEntity addProducts(@RequestParam String name,@RequestParam String description, @RequestParam double price,@RequestParam String category) {
		int cat_id=repo.findIdByName(category);
	     service.addProducts(name, description, price, cat_id);
		return ResponseEntity.ok().build();
		
		
	}


}
