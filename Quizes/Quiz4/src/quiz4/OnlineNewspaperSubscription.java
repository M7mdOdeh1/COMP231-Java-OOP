package quiz4;

public class OnlineNewspaperSubscription extends NewspaperSubscription  {

	public OnlineNewspaperSubscription() {
		super();
	}

	
	
	public OnlineNewspaperSubscription(String name, int days, String address) throws WrongOnlineAdress {
		super(name, days);
		setAddress(address);
		
	}



	@Override
	public void setAddress(String address) throws WrongOnlineAdress {
		
		if(address.equals(address.replaceAll("@", "")))
				throw new WrongOnlineAdress("Invalid Online address ");
		else {
			super.address= address;	
			super.setRate(0.9);
		}
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
