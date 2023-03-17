package question2;

import java.util.*;

public class Q2 {
	public static void main(String[] args) {
		int size=4;
		int[] temp= new int[10];
		
		MyArray[] array= new MyArray[size];
		Random random = new Random();
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<temp.length; j++) {
				temp[j]=random.nextInt(100);
			}
			array[i]= new MyArray(temp);	
		}
		
		for(int i=0; i<array.length; i++) {
			System.out.println("Max in array " +(i+1)+" is: " + array[i].Max());
			System.out.println("Min in array " +(i+1)+" is: " + array[i].Min());
			System.out.printf("Average in array %d is %.2f \n", (i+1) , array[i].Average());
			System.out.println("Size of array "+(i+1)+ " is: "+ array[i].getSize());
		}
		
	}

}
