package quiz4;

public class PhysicalNewspaperSubscription extends NewspaperSubscription {

	public PhysicalNewspaperSubscription() {
		super();
	}
	

	
	public PhysicalNewspaperSubscription(String name, int days, String address) throws WrongPysicalAdress {
		super(name, days);
        setAddress(address);
	}




	@Override
	public void setAddress(String address) throws WrongPysicalAdress {
		
			if(address.equals(address.replaceAll("[1-9]", "")))
					throw new WrongPysicalAdress("Invalid physical address");
			else {
				super.address= address;
				super.setRate(15);
			}
	}
	
	public double computePayment() {
		return super.getRate()* super.getDays() + 3;
	}

	@Override
	public String toString() {
		return "PhysicalNewspaperSubscription [getPayment()=" + computePayment() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
