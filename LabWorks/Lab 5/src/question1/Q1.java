package question1;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
 
    	Scanner inp=new Scanner(System.in);
    	int size=1;
    	Employee []employee=new Employee[size];
    	
    	for(int i=0; i<employee.length;i++) {
    		System.out.println("enter the emoployee info");
            System.out.println("name: ");
            String name=inp.next();
            System.out.println("department No.: ");
            int dep=inp.nextInt();
            System.out.println("id: ");
            long id=inp.nextLong();
            System.out.println("birthdate (year month day: ");
            int year=(inp.nextInt()-1900);
            int month=(inp.nextInt()-1);
            int day=inp.nextInt();
            Date birthdate=new Date(year,month,day);
            System.out.println("hire (year month day: ");
            int hireYear=(inp.nextInt()-1900);
            int hireMonth=(inp.nextInt()-1);
            int hireDay=inp.nextInt();
            Date hiredate=new Date(hireYear,hireMonth,hireDay);
            System.out.println("basic salary: ");
            double basicsalary=inp.nextDouble();
             
          employee[i]=new Employee(dep,name,id,birthdate,hiredate,basicsalary);
    	}
    	largestSalary(employee);
    	printInfo(employee);
    	
    }
    
    public static Employee largestSalary(Employee[] emp) {
    	double max=emp[0].getBasicSalary();
    	int empNo=0;
    	for(int i=1;i<emp.length;i++) {
    		if(max < emp[i].getBasicSalary()) {
    			max=emp[i].getBasicSalary();
    			empNo=i;
    		}
    			
    	}
    	return emp[empNo];
    }
    
    public static void printInfo(Employee[] empo) {
    	
    	for(Employee i:empo) {
    		System.out.println(i.toString());
    	}
    }
}
