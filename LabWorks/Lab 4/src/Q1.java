import java.util.*;
public class Q1 {

	public static void main(String[] args) {
	  
		Scanner inp=new Scanner(System.in);
        System.out.println("Enter the number of apartments");  
        int no_of_floor=inp.nextInt();
        int[] apart=new int[no_of_floor];
        
         for(int i=0;i<apart.length;i++) {
        	 System.out.println("Enter the number of people in apartment number "+i);
        	 apart[i]=inp.nextInt();
         }
         int n=noOfpeople(apart);
         System.out.println("the number of people in the building is "+ n);
       
         int avg=peopleAvg(n,no_of_floor);
       	 System.out.println("the avarage number of people per apartment "+avg);
       	 
       	 for(int i=0;i<apart.length;i++) {
       		 if (apart[i]<=avg) {
       			 int diff=avg-apart[i];
       			 System.out.println("the apartment"+i+" is below-average by "+diff);
       		 }
       		 else {
       			int diff=apart[i]-avg;
       			 System.out.println("the apartment"+i+ " is above-average by "+diff);  
       		 }
       	 }
       	 
       	 //creating new array for part two of the question
       	 int [][]building=new int[no_of_floor][];
       	  
       	  for(int i=0;i<building.length;i++) {
       		  building[i]=new int[apart[i]+1];              //apart[i] is the number of people in the apartment
       		  System.out.println("enter the ages of "+ apart[i] + " people in apartment number "+i);
       		  for(int j=1;j<building[i].length;j++) {
       			building[i][j]= inp.nextInt();
       		 }
       	  }
       	  
       	  System.out.println("the agerage of ages is "+ averageAges(building)); 
       
        
	}
	
	public static int noOfpeople(int []a) {
		int sum=0;
		for(int i=0; i<a.length;i++) {
			sum+=a[i];
		}
		return sum;
	}

	public static int peopleAvg(int n,int no_of_apartment ) {
     	int avg=0;
     	avg=n/no_of_apartment;
		
     	return avg;
	}
	
	public static double averageAges(int[][]building) {
	  double sum=0;
	  int count=0;
	    for(int i=0;i<building.length;i++) {
	    	for(int j=1;j<building[i].length;j++) {
	    	sum+=building[i][j];
	    	count++;
	    	}
	    }
		return sum/count;	
	}

	
}
