package com.example.S13SpringBootREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.S13SpringBootREST.entity.adminUser;
@Repository
public interface adminloginRepository extends JpaRepository<adminUser,String> {
  adminUser findByUsernameAndPassword(String username,String password);
  
}
