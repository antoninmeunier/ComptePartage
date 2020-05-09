package com.share.PartageDepenses.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.share.PartageDepenses.entities.User;

@CrossOrigin("*")
@RepositoryRestController
public interface UserRepository extends JpaRepository<User,Long>{


}
