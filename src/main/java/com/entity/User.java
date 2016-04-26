package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
//	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "userrole")
	@Enumerated(EnumType.ORDINAL)
	private UserroleEnum userrole;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public User(String username,String password, UserroleEnum userrole) {
		super();
		this.username = username;
		this.password = password;
		this.userrole = userrole;
	
	}
	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserroleEnum getUserrole() {
		return userrole;
	}

	public void setUserrole(UserroleEnum userrole) {
		this.userrole = userrole;
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
	

}
