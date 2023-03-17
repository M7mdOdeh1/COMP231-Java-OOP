package question1;

public class Driver {

	public static void main(String[] args) {

		Saving save= new Saving(231, 400);
		Checking check= new  Checking(123, 500);
		
		save.Withdraw(200);
		save.Deposit(100);
		
		check.Withdraw(400);
		check.Deposit(100);
		
		
	printAccountInfo(save);	
	printAccountInfo(check);	
		
		
	}
	
	public static void printAccountInfo(Account acc) {
		if(acc instanceof Saving) 
		   System.out.println( ((Saving)acc).toString());	
		   
		else if (acc instanceof Checking)
			System.out.println(((Checking)acc).toString());
		
	}
	
	
	

}
