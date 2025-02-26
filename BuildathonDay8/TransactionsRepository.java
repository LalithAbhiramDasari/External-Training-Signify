package com.training.PersonalFinanceManagementSystem.Repositories;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.PersonalFinanceManagementSystem.Models.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> 
{
	@Query(value = "SELECT category, SUM(amount) as total FROM Transactions WHERE user_id = ?1 AND transaction_type = 'Expense' GROUP BY category", nativeQuery = true)
	List<Map<String, String>> UserExpensesByCategory(Long userId);
}
