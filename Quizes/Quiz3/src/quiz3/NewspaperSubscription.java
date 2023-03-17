package quiz3;

public class NewspaperSubscription {
	
	private String name;
	private String address;
	private double rate;
	private int days;
	
	
	public NewspaperSubscription() {
	}
	


	public NewspaperSubscription(String name, int days) {
		super();
		this.name = name;
		this.days = days;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public double getRate() {
		return rate;
	}
	
	public void setAddress(String address) {
		this.address= address;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		
		return "NewspaperSubscription [name=" + name + ", address=" + address + ", rate=" + rate + ", days=" + days
				+ "]";
	}
	
	

}
