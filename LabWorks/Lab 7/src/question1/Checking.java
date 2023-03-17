package question1;

public class Checking extends Account{
	private double overDraft;
	
	public Checking(int id, double balance) {
	    super(id, balance);
		this.overDraft=1000;
	}

 	    
	 public void Withdraw(double amount) {
	    	if(super.getBalance()+overDraft-amount<0)
	    		System.out.println("can't overdraft more than 1000$");
	    	
	    	else 
	    		{
	   // 		super.Withdraw(amount); 
	    		}
	 }


	@Override
	public void Deposit(double amount) {
		// TODO Auto-generated method stub
		super.Deposit(amount);
	}

	@Override
	public String toString() {
		return "this information about checking" + super.toString()  +"]";
	}
	

}
