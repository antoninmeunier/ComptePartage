package com.share.PartageDepenses.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class ComptePartage implements Serializable {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComptePartage;
	private long totalComptePartage;
	private String titreComptePartage;
	
	@OneToMany(mappedBy="comptePartage",fetch = FetchType.LAZY)
	private Collection<User> users;

	@OneToMany(mappedBy="beneficiaires")
	private Collection<User> depenses;

	
	
	//Getters & Setters
	public Long getIdComptePartage() {
		return idComptePartage;
	}

	public void setIdComptePartage(Long idComptePartage) {
		this.idComptePartage = idComptePartage;
	}

	public long getTotalComptePartage() {
		return totalComptePartage;
	}

	public void setTotalComptePartage(long totalComptePartage) {
		this.totalComptePartage = totalComptePartage;
	}

	public String getTitreComptePartage() {
		return titreComptePartage;
	}

	public void setTitreComptePartage(String titreComptePartage) {
		this.titreComptePartage = titreComptePartage;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Collection<User> getDepenses() {
		return depenses;
	}

	public void setDepenses(Collection<User> depenses) {
		this.depenses = depenses;
	}

	
	//Constructors 
	public ComptePartage(Long idComptePartage, long totalComptePartage, String titreComptePartage,
			Collection<User> users, Collection<User> depenses) {
		super();
		this.idComptePartage = idComptePartage;
		this.totalComptePartage = totalComptePartage;
		this.titreComptePartage = titreComptePartage;
		this.users = users;
		this.depenses = depenses;
	}

	public ComptePartage() {
		super();
	}
	
	
	
}
