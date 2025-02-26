package com.training.PersonalFinanceManagementSystem.Models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Transactions 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transaction_id;
	
	@JsonProperty("user_id")
	private Long user_id;
	
	@JsonProperty("transaction_type")
	private String transaction_type;
	
	@JsonProperty("amount")
	private double amount;
	
	@JsonProperty("category")
	private String category;
	
	@Column
	private LocalDateTime transation_date = LocalDateTime.now();
	
	@JsonProperty("notes")
	private String notes;

	public Long getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getTransation_date() {
		return transation_date;
	}

	public void setTransation_date(LocalDateTime transation_date) {
		this.transation_date = transation_date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Transactions(Long transaction_id, Long user_id, String transaction_type, double amount, String category,
			LocalDateTime transation_date, String notes) {
		super();
		this.transaction_id = transaction_id;
		this.user_id = user_id;
		this.transaction_type = transaction_type;
		this.amount = amount;
		this.category = category;
		this.transation_date = transation_date;
		this.notes = notes;
	}

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
