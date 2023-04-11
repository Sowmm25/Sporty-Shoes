package com.example.S13SpringBootREST.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.S13SpringBootREST.entity.adminUser;
@Repository
public interface updatePasswordRepository extends CrudRepository<adminUser,Integer> {
	adminUser findByUsername(String username);

}
