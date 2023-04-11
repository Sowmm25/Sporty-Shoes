package com.example.S13SpringBootREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.S13SpringBootREST.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,String>{
	//int findByName(String name);
@Query("select c.id from Category c where c.category_name=:category_name")
	int findIdByName(@Param("category_name") String category_name);

}
