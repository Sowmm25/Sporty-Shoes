package com.example.S13SpringBootREST;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages="com.example.S13SpromgBootREST.entity")


 
public class S13SpringBootRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(S13SpringBootRestApplication.class, args);
	}

}
 