package question3;

import java.util.*;

public class Q3 {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("enter the number of student");
		int size = inp.nextInt();
		Student[] student = new Student[size];

		for (int i = 0; i < student.length; i++) {
			System.out.println("enter the student id: ");
			int id = inp.nextInt();
			System.out.println("enter the student name: ");
			String name = inp.next();
			student[i] = new Student(id, name);
		}
	/*	for (int i = 0; i < student.length; i++) {
			System.out.println("Student "+(i+1)+ " name is " + student[i].getStudentName());
			System.out.println("Student "+(i+1)+" id is " + student[i].getStudentId());
		}
		*/
		printStudent(student);

	}
	
	public static void printStudent(Student[] st) {
		for(Student i:st) {
			System.out.println(i.toString());
		}
	}
}
