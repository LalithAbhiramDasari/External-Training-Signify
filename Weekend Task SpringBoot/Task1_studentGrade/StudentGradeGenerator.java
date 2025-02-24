package com.signify.student.studentGrade;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class Student 
{
    private String name;
    private String rollNumber;
    private String dateOfBirth;
    private String gender;
    private String admissionNumber;
    private String department;
    private String bloodGroup;
    private String address;
    private String pinCode;

    public String getName() 
    { 
    	return name; 
    }
    
    public void setName(String name) 
    { 
    	this.name = name; 
    }

    public String getRollNumber() 
    { 
    	return rollNumber; 
    }
    
    public void setRollNumber(String rollNumber) 
    { 
    	this.rollNumber = rollNumber; 
    }

    public String getDateOfBirth() 
    { 
    	return dateOfBirth; 
    }
    
    public void setDateOfBirth(String dateOfBirth) 
    { 
    	this.dateOfBirth = dateOfBirth; 
    }

    public String getGender() 
    { 
    	return gender; 
    }
    
    public void setGender(String gender) 
    { 
    	this.gender = gender; 
    }

    public String getAdmissionNumber() 
    { 
    	return admissionNumber; 
    }
    
    public void setAdmissionNumber(String admissionNumber) 
    { 
    	this.admissionNumber = admissionNumber; 
    }

    public String getDepartment() 
    { 
    	return department; 
    }
    
    public void setDepartment(String department) 
    { 
    	this.department = department; 
    }

    public String getBloodGroup() 
    { 
    	return bloodGroup; 
    }
    
    public void setBloodGroup(String bloodGroup) 
    { 
    	this.bloodGroup = bloodGroup; 
    }

    public String getAddress() 
    { 
    	return address; 
    }
    
    public void setAddress(String address) 
    {
    	this.address = address;
    }

    public String getPinCode() 
    { 
    	return pinCode; 
    }
    
    public void setPinCode(String pinCode) 
    { 
    	this.pinCode = pinCode; 
    }

	@Override
	public String toString() 
	{
		return "Student [name=" + name + ", rollNumber=" + rollNumber + 
		           ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + 
		           ", admissionNumber=" + admissionNumber + ", department=" + department + 
		           ", bloodGroup=" + bloodGroup + ", address=" + address + 
		           ", pinCode=" + pinCode + "]";
	}
    
   
}

class SubjectMarks 
{
    private String subjectName;
    private int marksObtained;
    private int maxMarks;


    public String getSubjectName() 
    { 
    	return subjectName; 
    }
    
    public void setSubjectName(String subjectName) 
    { 
    	this.subjectName = subjectName; 
    }

    public int getMarksObtained() 
    { 
    	return marksObtained; 
    }
    
    public void setMarksObtained(int marksObtained) 
    { 
//    	if(marksObtained > maxMarks)
//    	{
//    		this.marksObtained = maxMarks;
//    	}
//    	else
//    	{
//    		this.marksObtained = marksObtained; 
//    	}
//    	
    	this.marksObtained = marksObtained;
    }

    public int getMaxMarks() 
    { 
    	return maxMarks; 
    }
    
    public void setMaxMarks(int maxMarks) 
    { 
    	this.maxMarks = maxMarks; 
    }
}

class Marks 
{
    private String rollNumber;
    private List<SubjectMarks> subjects;

    public String getRollNumber() 
    { 
    	return rollNumber; 
    }
    
    public void setRollNumber(String rollNumber) 
    { 
    	this.rollNumber = rollNumber; 
    }

    public List<SubjectMarks> getSubjects() 
    { 
    	return subjects; 
    }
    
    public void setSubjects(List<SubjectMarks> subjects) 
    { 
    	this.subjects = subjects; 
    }
}

@RestController
public class StudentGradeGenerator 
{
	@PostMapping("/studentEntry")
    public String studentEntry(@RequestBody Student student) 
	{
		
        return student.toString() + " added successfully!";
    }
	
	 @PostMapping("/findResult")
	public String findResult(@RequestBody Marks marks) 
	{
        List<SubjectMarks> subjectMarksList = marks.getSubjects();
        int totalObtained = 0;
        int totalMax = 0;

        for (SubjectMarks i : subjectMarksList) 
        {
            totalObtained += i.getMarksObtained();
            totalMax += i.getMaxMarks();
        }

        double percentage = (totalObtained * 100.0) / totalMax;
        String grade = "";
        if (percentage >= 90) grade = "S";
        else if (percentage >= 85) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 75) grade = "B+";
        else if (percentage >= 70) grade = "B";
        else if (percentage >= 65) grade = "C+";
        else if (percentage >= 60) grade = "C";
        else if (percentage >= 55) grade = "D+";
        else if (percentage >= 50) grade = "D";
        else grade = "F";
      
        String result = "";
        if(grade.equals("F"))
        {
        	result = "Failed";
        }
        else
        {
        	result = "Passed";
        }

        return "Student with Roll Number " + marks.getRollNumber() + 
                                 " has secured " +  percentage +"% "+  " with Grade " + grade + 
                                 ". Result: " + result;
    }
}
