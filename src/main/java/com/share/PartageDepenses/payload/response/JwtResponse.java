package com.share.PartageDepenses.payload.response;

import java.util.Collection;
import java.util.List;

import com.share.PartageDepenses.entities.ComptePartage;

public class JwtResponse {
	
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private Collection<ComptePartage> comptePartages1User;
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
	
	
	public JwtResponse(String accessToken, Long id, String username, String email,
			Collection<ComptePartage> comptePartages1User, List<String> roles) {
		super();
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.comptePartages1User = comptePartages1User;
		this.roles = roles;
	}



	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public Collection<ComptePartage> getComptePartages1User() {
		return comptePartages1User;
	}


	
}
