package com.example.BuildathonDay6.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BuildathonDay6.Models.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
