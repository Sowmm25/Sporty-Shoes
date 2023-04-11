package com.example.S13SpringBootREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.S13SpringBootREST.entity.User;

import com.example.S13SpringBootREST.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserApiController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public Iterable<User> getUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUsers(@PathVariable("id") Integer id){
		return repository.findById(id).get();
	}
	
	@PostMapping
	public User create(@RequestBody User users){
		return repository.save(users);
	}
	
	@PutMapping
	public User update(@RequestBody User users){
		return repository.save(users);
	}
	

}
