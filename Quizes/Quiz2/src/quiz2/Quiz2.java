package quiz2;

import java.util.*;

public class Quiz2 {

	public static void main(String[] args) {	
		Scanner inp=new Scanner(System.in);
		int size=2;
		Student[]std= new Student[size];
		double[][]scores=new double[size][3];
		
		for (int i = 0; i < std.length; i++) {
			System.out.println("Enter first name , last name and student roll for student " + (i+1));
			String first_name= inp.next();
			String last_name= inp.next();
			int student_roll= inp.nextInt();
			
			System.out.println("enter scores for student "+ (i+1));
			for (int j = 0; j < scores[i].length; j++) {
				scores[i][j]= inp.nextDouble();
			}
			
			std[i]=new Student(first_name, last_name, student_roll, scores[i]); 	
		}
		maxGrade(std);

	}
	
	public static void maxGrade(Student[] std) {
	     double max=std[0].getAverage();
	     int index=0;
		for (int i = 0; i < std.length; i++) {
			if(max<std[i].getAverage()) {
				max= std[i].getAverage();
				index=i;
			}	
		}
		System.out.println("Information about student which has the max grade: ");
		System.out.println(std[index].toString()); 
	}

}
