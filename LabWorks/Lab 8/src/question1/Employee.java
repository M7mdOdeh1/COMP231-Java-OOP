package question1;

public abstract class Employee implements Comparable<Employee> {
	private String first_name;
	private String last_name;
	private int id;
	
	public Employee() {
		this("","",0);
	}

	public Employee(String first_name, String last_name, int id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int compareTo(Employee emp) {
		if(this.earning()- emp.earning()>0)
			return 1;
		else if(this.earning()- emp.earning()<0)
			return -1;
		else 
			return 0;
	}
	
	public abstract double earning();
	
	public abstract String toString();
	

}
