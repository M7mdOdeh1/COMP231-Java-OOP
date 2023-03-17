package question1;

public class Saving extends Account {
	
	
	public Saving(int id, double balance) {
	    super(id, balance);
	    
		
	}


	@Override
	public void Deposit(double amount) {
		super.Deposit(amount);
	}


	@Override
	public void Withdraw(double amount) {
		
		
		if(super.getBalance()-amount<0)
	    	System.out.println("error");
		else
			super.Withdraw(amount);
	}


	@Override
	public String toString() {
		return "this information about saving" + super.toString()  +"]";
	}



	
	
	
			


}
