package question1;

public class CommissionEmployee extends Employee {
	private double rate;
	private double grossRate;
	

	public CommissionEmployee() {
		rate=0;
		grossRate=0;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getGrossRate() {
		return grossRate;
	}

	public void setGrossRate(double grossRate) {
		this.grossRate = grossRate;
	}

	public CommissionEmployee(String first_name, String last_name, int id, double rate, double grossRate) {
		super(first_name, last_name, id);
		this.rate=rate;
		this.grossRate = grossRate;
	}

	@Override
	public double earning() {
		return rate*grossRate;
	}

	@Override
	public String toString() {
		return "CommissionEmployee [rate=" + rate + ", grossRate=" + grossRate + ", earning=" + earning()
				+ ", First_name=" + getFirst_name() + ", Last_name=" + getLast_name() + ", Id=" + getId()
				+ "]";
	}

	

}
