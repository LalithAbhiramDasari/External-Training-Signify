package com.example.BuildathonDay6.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("rollNumber")
	private String rollNumber;

	@JsonProperty("department")
	private String department;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  
    private List<Marks> marks;

	@JsonProperty("finalResult")
	private String finalResult;

	public Student() {
	}

	public Student(String name, String rollNumber, String department, List<Marks> marks, String finalResult) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.department = department;
		this.marks = marks;
		this.finalResult = finalResult;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Marks> getMarks() {
		return marks;
	}

	public void setMarks(List<Marks> marks) {
		this.marks = marks;
		if (marks != null) {
            for (Marks mark : marks) {
                mark.setStudent(this); 
            }
        }
	}

	public String getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(String finalResult) {
		this.finalResult = finalResult;
	}
}
