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

import com.example.BuildathonDay6.Models.Marks;
import com.example.BuildathonDay6.Models.Student;
import com.example.BuildathonDay6.Repository.StudentRepository;

import jakarta.transaction.Transactional;

@RestController
public class StudentController 
{
	@Autowired
	private StudentRepository studentRepo;

	@Transactional
	@PostMapping("/studentEntry")
	public ResponseEntity<Map<String, String>> addStudent(@RequestBody Student student)
	{
		boolean isPassed = true;
		for (Marks mark : student.getMarks())
		{
			String grade = calculateGrade((mark.getMarksObtained() * 100) / mark.getMaximumMarks());
			mark.setGrade(grade);
			if (grade.equals("F")) 
			{
				isPassed = false;
			}
		}

		student.setFinalResult(isPassed ? "Passed" : "Failed");
		
		studentRepo.save(student);

		Map<String, String> response = new HashMap<>();
		response.put("Status", "Student Added");
		response.put("Final Result", student.getFinalResult());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/viewStudents")
	public ResponseEntity<List<Student>> viewAll()
	{
		List<Student> list = studentRepo.findAll();
		return ResponseEntity.ok(list);
	}

	private String calculateGrade(int percentage) {
		if (percentage >= 90) return "S";
		if (percentage >= 85) return "A+";
		if (percentage >= 80) return "A";
		if (percentage >= 75) return "B+";
		if (percentage >= 70) return "B";
		if (percentage >= 65) return "C+";
		if (percentage >= 60) return "C";
		if (percentage >= 55) return "D+";
		if (percentage >= 50) return "D";
		return "F";
	}
}
