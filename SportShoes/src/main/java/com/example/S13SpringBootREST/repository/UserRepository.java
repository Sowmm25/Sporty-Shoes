package com.example.S13SpringBootREST.repository;

import com.example.S13SpringBootREST.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer>{
	 @Query("select c.id from User c where c.username=:username")
	int findIdByName(@Param("username") String username);
	//@Query("SELECT u FROM users u WHERE u.username = ?1")
    //  String findByUsername(String username);
	// User findByUsernameAndPassword(String username,String password);
	//List<Product> findByName(String name);

	//public User findByUsername(String username);
	
	//List<Product> findByPrice(Double price);

	//List<Product> findByNameAndPrice(String name,Double price);

}
