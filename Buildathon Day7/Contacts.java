package com.BuildathonDay7.OnlineContactManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contacts 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("phno")
	private Long phno;
	
	@JsonProperty("email")
	private String email;

	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contacts(Long id, String name, Long phno, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phno = phno;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
