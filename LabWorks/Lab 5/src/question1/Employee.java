package question1;

import java.util.Date;
public class Employee {
	
  private int departmentNo;
  private String name;
  private long id;
  private Date birthDate=new Date();
  private Date hireDate=new Date();
  private double basicSalary;
  
   public Employee() {   
   }
   
   public Employee(int departmentNo, String name,long id,Date birthDate, Date hireDate, double basicSalary) {
	   this.departmentNo=departmentNo;
	   this.name=name;
	   this.id=id;
	   this.birthDate=birthDate;
	   this.hireDate=hireDate;
	   this.basicSalary=basicSalary;
   }
    
   public void setDepartmentNo(int number) {
	   departmentNo = number ;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setId(long number) {
		id = number;
	}

	public long getId() {
		return id;
	}
	
	public void setBasicSalary(double number) {
		basicSalary = number;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public String getName() {
		return name;
	}

	public Date getHireDate() {
		return hireDate;			
	}	
	
	public Date getBirthDate() {
		return birthDate;			
	}

	@Override
	public String toString() {
		return "Employee [departmentNo=" + departmentNo + ", name=" + name + ", id=" + id + ", birthDate=" + birthDate
				+ ", hireDate=" + hireDate + ", basicSalary=" + basicSalary + "]";
	} 
	
	
		
}
