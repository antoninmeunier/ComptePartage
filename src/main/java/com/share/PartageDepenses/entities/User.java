package com.share.PartageDepenses.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User implements Serializable {

	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idUser;
	private String nom;
	private String prenom;
	private String pseudo;
	
	@ManyToOne
	@JoinColumn(name="idComptePartage")
	private ComptePartage comptePartage;
	
	
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
	
	
	
	// Constructors
	
	public User(Long idUser, String nom, String prenom, String pseudo) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
	}
	public User() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + "]";
	}

	
	
	
}
