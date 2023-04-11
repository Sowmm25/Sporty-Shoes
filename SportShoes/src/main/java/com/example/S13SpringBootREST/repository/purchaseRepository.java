package com.example.S13SpringBootREST.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.S13SpringBootREST.entity.Purchase;

@Repository
public interface purchaseRepository extends CrudRepository<Purchase,Integer> {

}
