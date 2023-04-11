package com.example.S13SpringBootREST.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.S13SpringBootREST.entity.Product;
import com.example.S13SpringBootREST.repository.CategoryRepository;
import com.example.S13SpringBootREST.repository.ProductRepository;

@Service
public class UserService {

	@Autowired
	private ProductRepository repository;
	
	public void addProducts(String product_name, String product_description,double price,int cat_id) {
		Product product=new Product();
		product.setCat_id(cat_id);
		product.setPrice(price);
		product.setProduct_name(product_name);
		product.setProduct_description(product_description);
		repository.save(product);
	}
	
}
