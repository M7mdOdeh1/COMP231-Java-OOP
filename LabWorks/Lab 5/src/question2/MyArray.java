package question2;

public class MyArray {
	private int arr[];


	public MyArray(int[]arr) {
		this.arr=arr;
	}
	
	public int Min() {
		int min=arr[0];
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i])
				min=arr[i];	  
		}
		return min;
	}
	
	public int Max() {
		int max=arr[0];
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i])
				max=arr[i];	  
		}
		return max;
	}
	
	public double Average() {
		double sum=0;
		for(int i=0; i< arr.length; i++) {
			sum+=arr[i];
		}
		return sum/arr.length;
	}
	
	public void printArray() {
		for(int i:arr)
			System.out.println(i);
	}
	
	public int getSize() {
		return arr.length;
	}
	
	
	
	

}
