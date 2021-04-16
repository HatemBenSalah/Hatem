package com.hms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hms.repositories.AppSettingsRepository;

@SpringBootApplication
public class TemplateApp {
	
	@Autowired
	AppSettingsRepository settings;

	public static void main(String[] args) {
		SpringApplication.run(TemplateApp.class, args);
	}

}