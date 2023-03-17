package question1;

public class HourlyEmployee extends Employee {
	
	private double wage;
	private int no_of_hours;

	public HourlyEmployee() {
		this.wage=0;
		this.no_of_hours=0;
	}

	public HourlyEmployee(String first_name, String last_name, int id, double wage, int no_of_hours) {
		super(first_name, last_name, id);
		this.wage=wage;
		this.no_of_hours= no_of_hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public int getNo_of_hours() {
		return no_of_hours;
	}

	public void setNo_of_hours(int no_of_hours) {
		this.no_of_hours = no_of_hours;
	}

	@Override
	public double earning() {
		return wage* no_of_hours;
	}

	@Override
	public String toString() {
		return "HourlyEmployee [wage=" + wage + ", no_of_hours=" + no_of_hours + ", earning=" + earning()
				+ ", First_name=" + getFirst_name() + ", Last_name=" + getLast_name() + ", getId=" + getId()
				+ "]";
	}

	

}
