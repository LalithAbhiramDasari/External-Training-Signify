package com.training.PersonalFinanceManagementSystem.Controllers;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.PersonalFinanceManagementSystem.Models.Transactions;
import com.training.PersonalFinanceManagementSystem.Models.Users;
import com.training.PersonalFinanceManagementSystem.Repositories.TransactionsRepository;

import jakarta.persistence.Entity;

@RestController
public class TransactionsController 
{
	@Autowired
	private TransactionsRepository transactionRepo;
	
	@PostMapping("addTrasaction")
	public ResponseEntity<Transactions> addTrasaction(@RequestBody Transactions t)
	{
		Transactions tObj = transactionRepo.save(t);
		return ResponseEntity.ok(tObj);
	}
	
	@GetMapping("/getTransactions")
	public ResponseEntity<List<Transactions>> getAllTransactions() 
	{
		List<Transactions> transactions = transactionRepo.findAll();
		return ResponseEntity.ok(transactions);
	}
	
	@PostMapping("/expensesByCategory")
	public ResponseEntity<List<Map<String,String>>> expensesCategory(@RequestBody Transactions t)
	{
		List<Map<String,String>> list = transactionRepo.UserExpensesByCategory(t.getUser_id());
		return ResponseEntity.ok(list);
	}
	
	
	
}
