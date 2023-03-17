package quiz3;

public class OnlineNewspaperSubscription extends NewspaperSubscription  {

	public OnlineNewspaperSubscription() {
		super();
	}

	
	
	public OnlineNewspaperSubscription(String name, int days, String address) {
		super(name, days);
		setAddress(address);
		
	}



	@Override
	public void setAddress(String address) {
		
		if(address.equals(address.replaceAll("@", "")))
				{
			System.out.println("error");
			super.setRate(0);
				}
		else {
			super.setAddress(address);		
			super.setRate(1.2);
		}
		super.setAddress(address);
	}
	
	public double computePayment() {
		return super.getRate()* super.getDays() + 1.5;
	}

	@Override
	public String toString() {
		return "OnlineNewspaperSubscription [computePayment()=" + computePayment() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
	

}
