package com.share.PartageDepenses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.share.PartageDepenses.dao.ComptePartageRepository;
import com.share.PartageDepenses.dao.DepenseRepository;
import com.share.PartageDepenses.dao.UserRepository;
import com.share.PartageDepenses.entities.ComptePartage;
import com.share.PartageDepenses.entities.Depense;
import com.share.PartageDepenses.entities.User;

@SpringBootApplication
public class PartageDepensesApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DepenseRepository depenseRepository;
	
	@Autowired
	ComptePartageRepository comptePartageRepository;
	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(PartageDepensesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
//		User user1= new User("Cousin", "Théau", "Babs");
//		User user2= new User("Bonhommet","Romain","Triathlon");
//		User user3= new User("Marland","Quentin","15");
//		List<User> users = new ArrayList<User>();
//		users.add(user1);
//		users.add(user2);
//		users.add(user3);
//		ComptePartage tricount1= new ComptePartage("TricountSki");
//		ComptePartage tricount2= new ComptePartage("Solo");
//		tricount1.setTotalComptePartage(1000);
//		List<ComptePartage> comptePartages= new ArrayList<ComptePartage>();
//		comptePartages.add(tricount1);
//		comptePartages.add(tricount2);	
//		user1.setComptePartages(comptePartages);
//		
//		Depense d1= new Depense("courses", 10, user1.getPrenom() ,new Date(), tricount1);
//		userRepository.save(user1);
//		userRepository.save(user2);
//		userRepository.save(user3);
//		depenseRepository.save(d1);
		
		
	}

}
