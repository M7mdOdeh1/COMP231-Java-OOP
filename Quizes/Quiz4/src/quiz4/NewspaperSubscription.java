package quiz4;


public abstract class NewspaperSubscription implements Comparable<NewspaperSubscription> {
	
	protected String name;
	protected String address;
	protected double rate;
	protected int days;
	
	
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
	
	public abstract void setAddress(String address) throws WrongOnlineAdress, WrongPysicalAdress ;
		
	


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
	
	public int compareTo(NewspaperSubscription a) {
		return this.getName().compareTo(a.getName());
	}
	
	
	
	

}
