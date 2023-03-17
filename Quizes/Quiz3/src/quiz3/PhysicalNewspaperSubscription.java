package quiz3;

public class PhysicalNewspaperSubscription extends NewspaperSubscription {

	public PhysicalNewspaperSubscription() {
		super();
	}
	

	
	public PhysicalNewspaperSubscription(String name, int days, String address) {
		super(name, days);
        setAddress(address);
	}




	@Override
	public void setAddress(String address) {
		
			if(address.equals(address.replaceAll("[1-9]", "")))
					{
				System.out.println("error");
				super.setRate(0);
					}
			else {
				super.setAddress(address);		
				super.setRate(3.5);
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
