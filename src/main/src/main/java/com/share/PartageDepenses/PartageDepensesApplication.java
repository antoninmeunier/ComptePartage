package com.share.PartageDepenses;

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
import com.share.PartageDepenses.entities.Role;
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
		repositoryRestConfiguration.exposeIdsFor(ComptePartage.class);
		repositoryRestConfiguration.exposeIdsFor(Depense.class);
		repositoryRestConfiguration.exposeIdsFor(User.class);
		repositoryRestConfiguration.exposeIdsFor(Role.class);
}
}
