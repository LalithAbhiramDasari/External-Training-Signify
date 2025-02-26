package com.training.PersonalFinanceManagementSystem.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.PersonalFinanceManagementSystem.Models.Users;



public interface UserRepository extends JpaRepository<Users, Long>
{
	@Query(value = "Select * from Users where user_name = ?1", nativeQuery = true)
	public List<Users> userLogin(String user_name, String password);
}
