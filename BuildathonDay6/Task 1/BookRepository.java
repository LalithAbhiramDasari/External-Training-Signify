package com.example.BuildathonDay6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BuildathonDay6.Models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
