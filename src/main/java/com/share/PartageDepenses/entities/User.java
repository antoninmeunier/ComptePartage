package com.share.PartageDepenses.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable {

	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idUser;
	private String nom;
	private String prenom;
	private String pseudo;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(
			name="User_comptes",
			joinColumns= {@JoinColumn(name="idUser")},
			inverseJoinColumns= {@JoinColumn(name="idComptePartage")}
			)
	private Collection<ComptePartage> comptePartages1User;
	
	
	//Getters & Setters
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public Collection<ComptePartage> getComptePartages() {
		return comptePartages1User;
	}
	public void setComptePartages(Collection<ComptePartage> comptePartages1User) {
		this.comptePartages1User = comptePartages1User;
	}

		// Constructors

	public User( String nom, String prenom, String pseudo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
	}
	public User() {
		super();
	}
	
	public User(String nom, String prenom, String pseudo, Collection<ComptePartage> comptePartages1User) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.comptePartages1User = comptePartages1User;
	}
	
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + "]";
	}

	
	
	
}
