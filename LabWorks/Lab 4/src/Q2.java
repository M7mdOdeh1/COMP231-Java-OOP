import java.util.*;

public class Q2 {

	public static void main(String[]args) {
		
		int[] arr= {2,5,6,7,8,1,3,6,9};
	 System.out.println("enter the number you want to search");
	 Scanner inp=new Scanner(System.in);
	 int key=inp.nextInt();
     int res=linearSearch(arr,key);
     if(res>=0)
    	 System.out.println("the number is in the index number "+ res);
     else
    	 System.out.println("not found");
		
		inp.close();
	}
	
	public static int linearSearch(int[] arr,int key) {
		for(int i=0;i<arr.length;i++) {
		 if(arr[i]==key)
			 return i;
		}
		return -1;
	}
}
