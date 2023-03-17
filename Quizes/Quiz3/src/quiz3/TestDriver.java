package quiz3;

import java.util.*;

public class TestDriver {

	public static void main(String[] args) {
		
		ArrayList<NewspaperSubscription > newspaper= new ArrayList<>();
		
	newspaper.add(new PhysicalNewspaperSubscription("mohammad",5, "mo2h"));   // String name, int days, String address
	newspaper.add(new OnlineNewspaperSubscription("mohammad",5, "mo@h"));
		
        System.out.println("total payment: "+ printInfo(newspaper));
	}
	
	public static double printInfo(ArrayList<NewspaperSubscription> newspaper) {
		double sum=0;
	
		for(int i=0; i<newspaper.size();i++) {
			if(newspaper.get(i) instanceof PhysicalNewspaperSubscription)
				sum += ((PhysicalNewspaperSubscription)newspaper.get(i)).computePayment();
				
				else if(newspaper.get(i) instanceof OnlineNewspaperSubscription)
					sum += ((OnlineNewspaperSubscription)newspaper.get(i)).computePayment();
		}
		
		return sum;
    }
	
	
}
