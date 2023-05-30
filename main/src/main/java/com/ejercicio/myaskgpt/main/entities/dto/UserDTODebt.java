package com.ejercicio.myaskgpt.main.entities.dto;

public class UserDTODebt {

	private long userID;

	private String username;
	
	private double debt;

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

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}
	
	
}
