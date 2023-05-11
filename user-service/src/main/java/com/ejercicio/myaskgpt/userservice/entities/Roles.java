package com.ejercicio.myaskgpt.userservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long roleID;
	
	@Column
	private String accessType;

	public Roles(String accessType) {
		super();
		this.accessType = accessType;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public long getRoleID() {
		return roleID;
	}
	
	
}
