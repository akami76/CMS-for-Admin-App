package com.app.cms.adminapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class AdminappApplication {


	@RequestMapping("/")
	String hello(){
		return "Hello World!";
	}


	public static void main(String[] args) {
		SpringApplication.run(AdminappApplication.class, args);
	}
}
