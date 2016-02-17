package com.java.training.hibernate.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3851597169979861307L;
	
	@Id @GeneratedValue
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	
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
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + "]";
	}
	

}
