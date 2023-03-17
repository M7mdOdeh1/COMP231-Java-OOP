package question1;

public class SalariedEmployee extends Employee {
	private double weaklySalary;
	
	public SalariedEmployee(String first_name,String last_name,int id, double weaklySalary) {
		super(first_name, last_name, id);
		this.weaklySalary= weaklySalary;
	}
	
	public SalariedEmployee() {
		this.weaklySalary=0;
	}
	
	public double earning() {
		return this.weaklySalary*4;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [weaklySalary=" + weaklySalary + ", First_name=" + getFirst_name()
				+ ", Last_name=" + getLast_name() + ", Id=" + getId() + "]";
	}
	
	

}
