package assignment2;

import java.util.*;

public class Students {
	private String first_name ;
	private String last_name;
	private int id;
	private Date birthDate;
	private double grade;
	private String email;
	
	public Students() {  //no arg constructor
	}

	public Students(String first_name, String last_name, int id, Date birthDate) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.id = id;
		this.birthDate = birthDate;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}
	
	public void generateEmail() {   //generate email for the student
		this.email= String.valueOf(first_name.toLowerCase().charAt(0)) + last_name.toLowerCase() +"@ritaj.birzeit.edu";
	}		
	
}
