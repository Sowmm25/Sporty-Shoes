package com.example.S13SpringBootREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.S13SpringBootREST.entity.User;

@Repository
public interface loginRepository extends JpaRepository<User,String>{
	 User findByUsernameAndPassword(String username,String password);
	 @Query("select c.id from User c where c.username=:username")
		int findIdByName(@Param("username") String username);
	
}
