package com.training.PersonalFinanceManagementSystem.Models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("user_name")
	private String user_name;
	
	@JsonProperty("password")
	private String password;
	
	@Column
	private LocalDateTime date = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Users(Long id, String user_name, String password, LocalDateTime date) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.date = date;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
