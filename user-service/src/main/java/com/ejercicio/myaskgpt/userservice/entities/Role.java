package com.ejercicio.myaskgpt.userservice.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4027272062660029455L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long roleID;
	
	@Column
	private String accessType;
	
	public Role() {
		super();
	}
	
	public Role(String accessType) {
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
