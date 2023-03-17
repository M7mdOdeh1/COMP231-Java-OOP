package question1;

public class BaseCommissionEmployee extends CommissionEmployee {
	private double baseSalary;

	public BaseCommissionEmployee() {
		baseSalary=0;
	}

	public BaseCommissionEmployee(String first_name, String last_name, int id, double rate, double grossRate, double baseSalary) {
		super(first_name, last_name, id, rate, grossRate);
		this.baseSalary= baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	@Override
	public double earning() {
		return baseSalary + super.earning();
	}

	@Override
	public String toString() {
		return "BaseCommissionEmployee [baseSalary=" + baseSalary + ", Rate=" + getRate() + ", GrossRate="
				+ getGrossRate() + ", First_name=" + getFirst_name() + ", Last_name=" + getLast_name()
				+ ", getId=" + getId() + "]";
	}

	
	
	
	
	
	

}
