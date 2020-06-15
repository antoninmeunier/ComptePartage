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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = { 
	@UniqueConstraint(columnNames = "email"),
	@UniqueConstraint(columnNames = "username") 
})
public class User implements Serializable {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idUser;
	@NotBlank
	private String email;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	@ManyToMany(mappedBy="users")
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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	public User(String email, Collection<ComptePartage> comptePartages1User) {
		super();
		this.email = email;
		this.comptePartages1User = comptePartages1User;
	}

	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(String email, String username, String password, Set<Role> roles) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	

	@Override
	public String toString() {
		return "User [idUser=" + idUser + " prenom=" +  ", email=" + email+"]";
	}
	
	
}
