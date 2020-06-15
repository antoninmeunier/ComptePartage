package com.share.PartageDepenses.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Depense implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepense;
	@NotBlank
	private String titre;
	@NotBlank
	private long montant;
	@NotBlank
	private String payeur;
	private Date date;

	@ManyToOne
	@JoinColumn(name="idComptePartage")
	private ComptePartage comptePartage;
	

	
	// Getters & Setters
	public Long getIdDepense() {
		return idDepense;
	}

	public void setIdDepense(Long idDepense) {
		this.idDepense = idDepense;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public long getMontant() {
		return montant;
	}

	public void setMontant(long montant) {
		this.montant = montant;
	}

	public String getPayeur() {
		return payeur;
	}

	public void setPayeur(String payeur) {
		this.payeur = payeur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ComptePartage getComptePartage() {
		return comptePartage;
	}

	public void setComptePartage(ComptePartage comptePartage) {
		this.comptePartage = comptePartage;
	}

	
	// Constructors

//
//	public Depense(String titre, long montant, User payeur, Date date, Collection<User> beneficiaires) {
//		super();
//		this.titre = titre;
//		this.montant = montant;
//		this.payeur = payeur;
//		this.date = date;
//		this.beneficiaires = beneficiaires;
//	}
	

	public Depense() {
		super();
	}

	public Depense(String titre, long montant, String payeur, Date date) {
	super();
	this.titre = titre;
	this.montant = montant;
	this.payeur = payeur;
	this.date = date;
}

	public Depense(String titre, long montant, String payeur, Date date, ComptePartage comptePartage) {
		super();
		this.titre = titre;
		this.montant = montant;
		this.payeur = payeur;
		this.date = date;
		this.comptePartage = comptePartage;
	}
	
	
	public Depense(String titre, long montant, Date date, ComptePartage comptePartage) {
		super();
		this.titre = titre;
		this.montant = montant;
		this.date = date;
		this.comptePartage = comptePartage;
	}
	


	@Override
	public String toString() {
		return "Depense [idDepense=" + idDepense + ", titre=" + titre + ", montant=" + montant + ", payeur=" + payeur
				+ ", date=" + date + ", comptePartage=" + comptePartage + "]";
	}
	
	
	
	
	
}
