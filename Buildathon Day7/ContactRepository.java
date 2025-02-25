package com.BuildathonDay7.OnlineContactManagementSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.BuildathonDay7.OnlineContactManagementSystem.Models.Contacts;

import jakarta.transaction.Transactional;

public interface ContactRepository extends JpaRepository<Contacts, Long>
{	
	@Modifying
	@Transactional
	@Query(value = "Delete from contacts where email = ?1 ", nativeQuery = true)
	public void deleteContact(String email);
	
	@Modifying
	@Transactional
	@Query(value = "Update Contacts set name = ?2, email = ?3 where phno = ?1 ", nativeQuery = true)
	public void updateContact(Long phno, String name, String email);
}
