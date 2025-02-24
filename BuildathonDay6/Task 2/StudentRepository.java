package com.example.BuildathonDay6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BuildathonDay6.Models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
