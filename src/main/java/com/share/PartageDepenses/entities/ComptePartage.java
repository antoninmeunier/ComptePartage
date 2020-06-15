package com.share.PartageDepenses.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class ComptePartage implements Serializable {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComptePartage;
	private long totalComptePartage;
	@NotBlank
	private String titreComptePartage;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="User_comptes",
			joinColumns= {@JoinColumn(name="=idComptePartage")},
			inverseJoinColumns= {@JoinColumn(name="idUser")}
			)
	private Collection<User> users;

	@OneToMany(mappedBy="comptePartage",fetch = FetchType.LAZY)
	private Collection<Depense> depenses;

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

	public Collection<Depense> getDepenses() {
		return depenses;
	}

	public void setDepenses(Collection<Depense> depenses) {
		this.depenses = depenses;
	}

	//Constructors 
	
	public ComptePartage(String titreComptePartage) {
		super();
		this.totalComptePartage = 0;
		this.titreComptePartage = titreComptePartage;
	}

	public ComptePartage(long totalComptePartage, String titreComptePartage, Collection<User> users,
			Collection<Depense> depenses) {
		super();
		this.totalComptePartage = totalComptePartage;
		this.titreComptePartage = titreComptePartage;
		this.users = users;
		this.depenses = depenses;
	}

	public ComptePartage() {
		super();
	}
	
	
	
}
