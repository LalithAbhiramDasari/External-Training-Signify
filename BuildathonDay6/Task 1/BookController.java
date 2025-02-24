package com.example.BuildathonDay6.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BuildathonDay6.Models.Book;
import com.example.BuildathonDay6.Repository.BookRepository;

import jakarta.transaction.Transactional;

@RestController
public class BookController 
{
	@Autowired
	private BookRepository bookRepo;
	
	@Transactional
	@PostMapping("/BookEntry")
	public ResponseEntity<Map<String, String>> addBook(@RequestBody Book book)
	{
		Book bookObj = bookRepo.save(book);
		Map<String, String> response = new HashMap<>();
		response.put("Status", "Book Added");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/viewBooks")
	public ResponseEntity<List<Book>> viewAll()
	{
		List<Book> list = bookRepo.findAll();
		return ResponseEntity.ok(list);
	}
}
