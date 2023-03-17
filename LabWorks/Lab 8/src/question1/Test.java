package question1;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Employee> emp = new ArrayList<>();
		
		
		emp.add(new SalariedEmployee("mohammad", "odeh", 1234, 400));
		
		emp.add(new HourlyEmployee("ahamd", " sdfadf", 4321, 100, 7));
		
		emp.add(new CommissionEmployee("khalil", "mashw", 54612, 0.6, 400));
		
		emp.add(new BaseCommissionEmployee("jawad", "asdf", 13435, 0.6, 400, 1000));
		
		emp.add(new SalariedEmployee("ahd", "sdfd", 1254, 500));
		
		Sort(emp);
		System.out.println("sorted array:");
		printInfo(emp);
		
		System.out.println("total Salary is: " + totalEarning(emp));
	}
	
	public static double totalEarning(ArrayList<Employee> a) {
		double sum=0;
		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i).earning();
		}
		return sum;
	}
	
	public static void printInfo(ArrayList<Employee> a) {
		for (int i = 0; i < a.size(); i++) {
	      System.out.println(a.get(i).toString());
	      	
		}
			
	}
	
	public static void Sort(ArrayList<Employee> obj) {
		java.util.Collections.sort(obj);
	}

}

