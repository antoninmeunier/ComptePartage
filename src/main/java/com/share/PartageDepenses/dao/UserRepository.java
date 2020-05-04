package com.share.PartageDepenses.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.share.PartageDepenses.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{


}
