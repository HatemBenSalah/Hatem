package com.hms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateApp {
	
	@Autowired


	public static void main(String[] args) {
		SpringApplication.run(TemplateApp.class, args);
	}

}
