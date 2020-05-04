package com.share.PartageDepenses.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Depense {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepense;
	private String titre;
	private long montant;
	private User payeur;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="idComptePartage")
	private Collection<User> beneficiaires;

	
	
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

	public User getPayeur() {
		return payeur;
	}

	public void setPayeur(User payeur) {
		this.payeur = payeur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Collection<User> getBeneficiaires() {
		return beneficiaires;
	}

	public void setBeneficiaires(Collection<User> beneficiaires) {
		this.beneficiaires = beneficiaires;
	}
	
	
	
	// Constructors

	public Depense(Long idDepense, String titre, long montant, User payeur, Date date, Collection<User> beneficiaires) {
		super();
		this.idDepense = idDepense;
		this.titre = titre;
		this.montant = montant;
		this.payeur = payeur;
		this.date = date;
		this.beneficiaires = beneficiaires;
	}

	public Depense() {
		super();
	}
	
	
	
	
	
}
