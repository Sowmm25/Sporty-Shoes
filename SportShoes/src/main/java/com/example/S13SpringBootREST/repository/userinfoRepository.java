package com.example.S13SpringBootREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.S13SpringBootREST.entity.userinfo;
@Repository
public interface userinfoRepository extends CrudRepository<userinfo,Integer> {

}
