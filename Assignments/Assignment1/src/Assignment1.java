/*
 *Name : Mohammed Owda
 *Id   : 1200089
 *sec  : 15 
 */
import java.util.*;

public class Assignment1 {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int days;
		System.out.print("Enter the number of days that the patient has entered the hospital: ");
		for (days = inp.nextInt(); days <= 0; days = inp.nextInt()) // to sure that the number is positive
			System.out.print("Erorr!!! Please enter a positive number only : ");

		double[][] patient = new double[days][];
		for (int i = 0; i < patient.length; i++) { // read the number of readings for each day
			System.out.print("Enter the number of reading for day " + (i + 1) + " : ");
			int no_of_reading;
			// to sure that the number of readings is positive
			for (no_of_reading = inp.nextInt(); no_of_reading <= 0; no_of_reading = inp.nextInt())
				System.out.print("Error!!! Please enter a positive number only : ");
			
			patient[i] = new double[no_of_reading + 2]; // ragged array (number of column = number of readings+2)
			patient[i][0] = i + 1; // Fill the first column with days number
			patient[i][1] = no_of_reading; // Fill the second column with number of readings
		}

		for (int j = 0; j < patient.length; j++) // filling the array with temperatures
			for (int k = 2; k < patient[j].length; k++) {
				System.out.print("Enter the temperature " + (k - 1) + " of day " + (j + 1) + " : ");
				for (patient[j][k] = inp.nextDouble(); patient[j][k] > 45
						|| patient[j][k] < 30; patient[j][k] = inp.nextDouble()) // keep taking temperature until it
																				     	// between 30 and 45
					System.out.print("Error!!!  Please enter a temperature between 30 and 45: ");
			}
		System.out.println("-----------------------------------------------------");
		// print average,max and min
		double[] summary = Summary(patient);
		System.out.printf("The Average of temperatures is: %.2f \n", summary[0]);
		System.out.println("The maximum temperature is: " + summary[1] + "\nThe minimum temperature is: " + summary[2]);
		
		// print number of temperatures below or above average
		int[] below_above_count = countbelowAboveAverage(patient, summary[0]);
		System.out.println("Total number of temperatures below(or equal) to the average is: " + below_above_count[0]);
		System.out.println("Total number of temperatures above the average is: " + below_above_count[1]);
		
		// call function to sort the array and store it in another array
		double[][] patient_sorted = sortArray(patient);
		printArray(patient_sorted); // call function to print the sorted array
		
		if (leaveHospital(patient)) //check if patient can leave hospital
			System.out.println("Your average is stable, You can leave the hospital");
		else
			System.out.println("You can't leave the hospital");

		inp.close();
	}

	public static double[] Summary(double[][] arr) { // function to find the average,maximum and minimum of temperature
		double max = arr[0][2], min = arr[0][2], sum = 0, avg;
		int count = 0;
		for (int i = 0; i < arr.length; i++)
			for (int j = 2; j < arr[i].length; j++) {
				sum += arr[i][j]; // find the sum
				if (max < arr[i][j]) // find the maximum
					max = arr[i][j];
				if (min > arr[i][j]) // find the minimum
					min = arr[i][j];
				count++;
			}
		avg = sum / count;
		return new double[] { avg, max, min }; // return the result as an anonymous array
	}
	
	public static int[] countbelowAboveAverage(double[][] arr, double avg) { // function to count the number of
																				// temperatures below or above average
		int below_count = 0, above_count = 0;
		for (int i = 0; i < arr.length; i++)
			for (int j = 2; j < arr[i].length; j++) {
				if (arr[i][j] <= avg) // check if temperature is below or above average
					below_count++;
				else
					above_count++;
			}
		return new int[] { below_count, above_count }; // return the result as an anonymous array
	}
	
	public static double[][] sortArray(double[][] patient) { // function to sort the temperature of the array
		double[][] copy = new double[patient.length][];
		for (int i = 0; i < patient.length; i++) { // copy the patient array in another array
			copy[i] = new double[patient[i].length]; // creating the same no. of column for the copy array
			for (int j = 0; j < patient[i].length; j++)
				copy[i][j] = patient[i][j];
		}
		double temp;
		for (int i = 0; i < copy.length; i++) // sort all rows of the array
			for (int j = 2; j < copy[i].length - 1; j++) // sort a single row of the array
				for (int k = j + 1; k < copy[i].length; k++) {
					if (copy[i][j] > copy[i][k]) {
						temp = copy[i][j]; // Swapping array elements
						copy[i][j] = copy[i][k];
						copy[i][k] = temp;
					}
				}
		return copy;
	}
	
	public static void printArray(double[][] arr) { // Function to print the array
		System.out.println("====================Sorted Array=====================");
		System.out.println("Days\t #of readings\t Reading per day (in Celsius)");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 2)   // just to format the table
					System.out.print("\t ");
				System.out.print(arr[i][j] + "\t ");
			}
			System.out.println("");
		}
		System.out.println("=====================================================");
	}
	
	public static boolean leaveHospital(double[][] arr) { // function to check if patient can leave hospital
		double max1 = 0, max2 = 0;
		int x, y;
		double sum = 0, avg = 0;

		if (arr.length == 1) { // in order if the patient has entered the hospital just 1 day
			System.out.println("you must check your temperature for two days at least");
			return false;
		}
		for (int i = arr.length - 2; i < arr.length; i++) { // find the max two values of temp. for the last two days
			max1 = arr[i][2];
			max2 = arr[i][2];
			x = i;
			y = 2;
			for (int j = 2; j < arr[i].length; j++) { // Find the first max temperature
				if (arr[i][j] > max1) {
					max1 = arr[i][j];
					x = i;     // position for the first max temperature
					y = j;					
				}
			}
			if(max1 == arr[i][2] && arr[i].length>3) // If first max equal to first temp in the row
				max2 = arr[i][3];                    // set second max to second temp in the row (if it exists)
			
			for (int j = 2; j < arr[i].length; j++) { // Find the second max temperature
				if(arr[i].length == 3) {  // If there is just one reading in the day
					max2 = 0;
					break;
				}
				if (i == x && j == y) // To ignore (skip) the first max temperature
					continue;
				if (arr[i][j] > max2)
					max2 = arr[i][j]; 	
			}
			sum += (max1 + max2); // Store the sum of the largest two value for one row every loop
		}

		if(arr[arr.length-2].length == 3 ^ arr[arr.length-1].length == 3) // if one of last two days has one reading(not both) 
			avg = sum / 3;
		else if(arr[arr.length-2].length ==3 && arr[arr.length-1].length == 3) // if both last two days have one reading
			avg = sum / 2;
		else  
			avg = sum /4;
		
		System.out.printf("Your average is: %.2f \n", avg);
		if (avg >= 35.5 && avg <= 36.5)
			return true;

		return false;
	}
}
