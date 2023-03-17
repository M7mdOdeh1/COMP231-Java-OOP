package question3;

import java.util.*;

public class Q3 {

	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		int size=2;
	   City [] city=new City[size]; 
	   
	   for(int i=0;i<city.length;i++) {    //taking city information
		   System.out.println("Enter name, longitude, latitude and temperature of city "+ (i+1));
		   String name=inp.next();
		   double longitude=inp.nextDouble();
		   double latitude=inp.nextDouble();
		   int temp=inp.nextInt();
		   city[i]=new City(name, longitude,latitude,temp); //creating new object with the information
	   }
	   System.out.println("Please enter an average temperature");
	   int avgTemp= inp.nextInt(); 
	   belowAverage(city,avgTemp);  	 
	}
	
	//print all info. about cities that are below particular temperature 
	public static void belowAverage(City[] cities, int avgTemp ) {  
		System.out.println("Cities are below the average: ");
		for(int i=0; i<cities.length; i++) {      
			if(cities[i].getTemperature()<avgTemp)                   
					System.out.println(cities[i].toString());   //print all information				
			}
				
		}
}
		
	
	

