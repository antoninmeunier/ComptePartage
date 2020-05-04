package com.share.PartageDepenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.share.PartageDepenses.dao.ComptePartageRepository;
import com.share.PartageDepenses.dao.DepenseRepository;
import com.share.PartageDepenses.dao.UserRepository;

@SpringBootApplication
public class PartageDepensesApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ComptePartageRepository comptePartageRepository;
	
	@Autowired
	DepenseRepository depenseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PartageDepensesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
	}

}
