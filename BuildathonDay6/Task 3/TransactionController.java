package com.example.BuildathonDay6.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BuildathonDay6.Models.Transaction;
import com.example.BuildathonDay6.Repository.TransactionRepository;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/addTransaction")
    public ResponseEntity<Map<String, String>> addTransaction(@RequestBody Transaction transaction) {
    	Transaction trans = transactionRepository.save(transaction);
    	Map<String, String> response = new HashMap<>();
		response.put("Status", "Transaction Added");
		return ResponseEntity.ok(response);
    }

    @GetMapping("/viewTransactions")
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
}
