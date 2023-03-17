package assignment2;

import java.util.*;

public class Driver {

	public static void main(String[] args) {

		Scanner inp = new Scanner(System.in);
		System.out.print("Enter Number of classes: ");
		int no_of_classes = inp.nextInt();

		Students[][] std = new Students[no_of_classes][]; // number of row = number of classes
		for (int i = 0; i < std.length; i++) {
			System.out.print("Enter Number of students in class# " + (i + 1) + " : ");
			int no_of_student = inp.nextInt();
			std[i] = new Students[no_of_student]; // number of columns = number of students for the class

			System.out.println("Enter first name, last name, id, date of birth (day, month, year) for each student");
			for (int j = 0; j < std[i].length; j++) { // taking information for each student
				String first_name = inp.next();
				String last_name = inp.next();
				int id = inp.nextInt();

				int day = inp.nextInt(); // taking date information
				int month = inp.nextInt() - 1;
				int year = inp.nextInt() - 1900;
				Date birthDate = new Date(year, month, day);

				std[i][j] = new Students(first_name, last_name, id, birthDate); // create new object of Students Class

				std[i][j].generateEmail(); // generate email for each student
			}
		}

		Sort(std);

		for (int i = 0; i < std.length; i++) {   // taking grades for each student for the sorted names
			System.out.println("Enter the grades for students in class #" + (i + 1));
			for (int j = 0; j < std[i].length; j++) {
				System.out.print(std[i][j].getFirst_name() + " " + std[i][j].getLast_name() + " : ");
				std[i][j].setGrade(inp.nextDouble());
			}
		}

		printStudents(std); //print all students info for each class

		inp.close();
	}

	public static void Sort(Students[][] std) {    //sort students in each class according to last name

		for (int i = 0; i < std.length; i++) {
			for (int j = 0; j < std[i].length - 1; j++) {

				for (int k = j + 1; k < std[i].length; k++) {

					for (char c = 'A'; c < 'Z'; c++) { 
						//split last name according to c(character) to find the number of occurrences of c
						int count1 = std[i][j].getLast_name().toUpperCase().split(String.valueOf(c), -2).length - 1;
						int count2 = std[i][k].getLast_name().toUpperCase().split(String.valueOf(c), -2).length - 1;

						if (count1 > count2) // compare number of occurrences of c for two students
							break; 
						if (count1 < count2) 
						{
							Swap(std[i], j, k); // swap two students (std[i][j] and std[i][k])
							break;
						}
					}

				}
			}
		}
	}

	public static void Swap(Students[] std, int j, int k) { // Swap two element of the array of Students Object

		Students temp = std[j];
		std[j] = std[k];
		std[k] = temp;

	}

	public static double[] findAverage(Students[][] std) { // find the averages for each class

		double[] avg = new double[std.length];

		for (int i = 0; i < std.length; i++) {
			double sum = 0;

			for (int j = 0; j < std[i].length; j++) {
				sum += std[i][j].getGrade();
			}

			avg[i] = sum / std[i].length;
		}

		return avg;
	}

	public static void printStudents(Students[][] std) { //print students info and the average for each class

		double[] average = findAverage(std);

		for (int i = 0; i < std.length; i++) {

			System.out.println("\nClass #" + (i + 1) + " ordering");
			for (int j = 0; j < std[i].length; j++) {
				System.out.println(std[i][j].getFirst_name() + " " + std[i][j].getLast_name() + ", email:"
						+ std[i][j].getEmail() + ", " + std[i][j].getGrade());
			}

			System.out.println("AVG of class #" + (i + 1) + " : " + average[i] + "%");
		}
	}

}
