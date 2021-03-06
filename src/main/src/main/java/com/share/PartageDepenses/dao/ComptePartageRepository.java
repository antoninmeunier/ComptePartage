package com.share.PartageDepenses.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.share.PartageDepenses.entities.ComptePartage;

@CrossOrigin("*")
@RepositoryRestController
public interface ComptePartageRepository extends JpaRepository<ComptePartage, Long> {

	
}
