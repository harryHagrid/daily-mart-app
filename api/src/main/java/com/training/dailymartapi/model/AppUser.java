package com.training.dailymartapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AppUser {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long uid;
	private String name;
	private String email;
	private String password;
	
	@OneToOne
	private AppRole role;
	
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public AppRole getRole() {
		return role;
	}
	public void setRole(AppRole role) {
		this.role = role;
	}
	
	
	
	
	
	

}
