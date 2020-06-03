package com.share.PartageDepenses.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { 
	@UniqueConstraint(columnNames = "pseudo"),
	@UniqueConstraint(columnNames = "username") 
})
public class User implements Serializable {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idUser;
	private String pseudo;
	private String username;
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="User_comptes",
			joinColumns= {@JoinColumn(name="idUser")},
			inverseJoinColumns= {@JoinColumn(name="idComptePartage")}
			)
	private Collection<ComptePartage> comptePartages1User;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_idUser"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	//Getters & Setters
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<ComptePartage> getComptePartages() {
		return comptePartages1User;
	}
	public void setComptePartages(Collection<ComptePartage> comptePartages1User) {
		this.comptePartages1User = comptePartages1User;
	}
	
	
	public Collection<ComptePartage> getComptePartages1User() {
		return comptePartages1User;
	}
	public void setComptePartages1User(Collection<ComptePartage> comptePartages1User) {
		this.comptePartages1User = comptePartages1User;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

		// Constructors

	public User() {
		super();
	}
	
	public User(String pseudo, Collection<ComptePartage> comptePartages1User) {
		super();
		this.pseudo = pseudo;
		this.comptePartages1User = comptePartages1User;
	}

	public User(String pseudo, String username, String password) {
		super();
		this.pseudo = pseudo;
		this.username = username;
		this.password = password;
	}
	public User(String pseudo, String username, String password, Set<Role> roles) {
		super();
		this.pseudo = pseudo;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	

	@Override
	public String toString() {
		return "User [idUser=" + idUser + " prenom=" +  ", pseudo=" + pseudo+"]";
	}
	
	
}
