package com.BuildathonDay7.OnlineContactManagementSystem.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BuildathonDay7.OnlineContactManagementSystem.Models.Contacts;
import com.BuildathonDay7.OnlineContactManagementSystem.Repositories.ContactRepository;

@RestController
public class ContactController 
{
	@Autowired
	ContactRepository contactRepo;
	
	@PostMapping("/addUsers")
	public ResponseEntity<Map<String, String>> addUser(@RequestBody Contacts contact)
	{
		contactRepo.save(contact);
		Map<String, String> response = new HashMap<>();
		response.put("Contact Added", "Success");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<Contacts>> getAll()
	{
		List<Contacts> list = contactRepo.findAll();
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<Map<String, String>> delete(@RequestBody Contacts contact)
	{
		contactRepo.deleteContact(contact.getEmail());
		Map<String, String> response = new HashMap<>();
		response.put("Contact Deleted", "Success");
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/updateUser")
	public ResponseEntity<Map<String, String>> update(@RequestBody Contacts contact)
	{
		contactRepo.updateContact(contact.getPhno(), contact.getName(), contact.getEmail());
		Map<String, String> response = new HashMap<>();
		response.put("Contact Updated", "Success");
		return ResponseEntity.ok(response);
	}
}
