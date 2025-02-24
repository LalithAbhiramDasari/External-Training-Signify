package com.example.BuildathonDay6.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Marks 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonProperty("subjectName")
	private String subjectName;

	@JsonProperty("marksObtained")
	private int marksObtained;

	@JsonProperty("maximumMarks")
	private int maximumMarks;

	@JsonProperty("grade")
	private String grade;
	
	@ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonBackReference  
    private Student student;

	public Marks() {
	}

	public Marks(String subjectName, int marksObtained, int maximumMarks, String grade, Student student) {
		this.subjectName = subjectName;
		this.marksObtained = marksObtained;
		this.maximumMarks = maximumMarks;
		this.grade = grade;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public int getMaximumMarks() {
		return maximumMarks;
	}

	public void setMaximumMarks(int maximumMarks) {
		this.maximumMarks = maximumMarks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
