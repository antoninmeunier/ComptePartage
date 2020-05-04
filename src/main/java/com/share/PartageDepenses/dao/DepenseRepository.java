package com.share.PartageDepenses.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.share.PartageDepenses.entities.Depense;

public interface DepenseRepository extends JpaRepository<Depense, Long> {

}
