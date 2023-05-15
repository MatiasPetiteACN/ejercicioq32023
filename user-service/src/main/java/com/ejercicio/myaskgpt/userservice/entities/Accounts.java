package com.ejercicio.myaskgpt.userservice.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="accounts")
public class Accounts implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long accountID;

	@Column
	private String username;

	@Column
	private String password;
	
	@Column
	private double deuda;

	@Column
	private boolean enabled;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) 
	@JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "accountID"), inverseJoinColumns = @JoinColumn(name = "rolesID"), uniqueConstraints = {
			@UniqueConstraint(columnNames = {"accountID", "rolesID"})})
	private List<Roles> roles;

	public Accounts(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = true;
	}
	
	public Accounts() {
		super();
		this.enabled = true;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public long getAccountID() {
		return accountID;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

}
