package com.ma.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ma.pedidos.model")
@EnableJpaRepositories("com.ma.repository")
public class MainApp {

	public static void main(String[] args) {
		
		SpringApplication.run(MainApp.class, args);
	}

}
