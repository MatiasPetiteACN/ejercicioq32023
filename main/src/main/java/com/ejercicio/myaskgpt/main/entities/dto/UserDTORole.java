package com.ejercicio.myaskgpt.main.entities.dto;

import java.util.List;

import com.ejercicio.myaskgpt.main.entities.Role;

public class UserDTORole {

	private long userID;

	private String username;
	
	private List<Role> roles;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
