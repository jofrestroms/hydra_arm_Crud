package com.example.hydra_Crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.Example.hydra_Crud.app.Entity")
@EnableJpaRepositories("com.Example.hydra_Crud.app.Repository")
public class HydraCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HydraCrudApplication.class, args);
	}

}
