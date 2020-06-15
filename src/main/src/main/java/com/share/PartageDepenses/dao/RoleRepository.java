package com.share.PartageDepenses.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.share.PartageDepenses.entities.ERole;
import com.share.PartageDepenses.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);
}
