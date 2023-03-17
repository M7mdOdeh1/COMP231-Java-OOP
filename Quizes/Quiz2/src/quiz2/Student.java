package quiz2;

import java.util.*;

public class Student {
	private String first_name;
	private String last_name;
	private int student_roll;
	private double[] scores;
	
	public Student(String first_name, String last_name, int student_roll, double[] scores) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.student_roll = student_roll;
		this.scores = scores;
	    System.arraycopy(scores, 0, this.scores, 0, scores.length);
	}
	public Student() {
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
	public double[] getScores() {
		return scores;
	}
	public void setScores(double[] scores) {
		this.scores = scores;
	}
	public int getStudent_roll() {
		return student_roll;
	}
	public double getAverage() {
		double sum=0;
		for (int i = 0; i < scores.length; i++) {
			sum+=scores[i];
		}
		return sum/scores.length;
	}
	public String getLetterGrade() {
		double wats= getAverage(); 
		if(wats>=90)
			return "A";
		else if(wats>=85 && wats<90)
			return "A-";
		else if(wats>=80 && wats<85)
			return "B";
		else if(wats>=75 && wats<80)
			return "B-";
		else if(wats>=70 && wats<75)
			return "C";
		else if(wats>=60 && wats<70)
			return "D";
		else
			return "F";
	}
	@Override
	public String toString() {
		return "Student [first_name=" + first_name + ", last_name=" + last_name + ", student_roll=" + student_roll
				+ ", scores=" + Arrays.toString(scores) + ", getAverage()=" + getAverage() + "]";
	}
	
	
	
	

}
