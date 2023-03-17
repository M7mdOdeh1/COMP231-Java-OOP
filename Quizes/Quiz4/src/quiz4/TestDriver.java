package quiz4;

import java.util.*;

public class TestDriver {

	public static void main(String[] args) {
		
		ArrayList<NewspaperSubscription > newspaper= new ArrayList<>();
		try {
			newspaper.add(new PhysicalNewspaperSubscription("mohammad",5, "moh451"));   
			newspaper.add(new OnlineNewspaperSubscription("amer",49, "mo@h"));
			newspaper.add(new PhysicalNewspaperSubscription("sami",55, "mo"));
			newspaper.add(new OnlineNewspaperSubscription("amjad",100, "adsfal"));
			newspaper.add(new OnlineNewspaperSubscription("ahmad",20, "mo@gmail.com"));
		}catch(WrongOnlineAdress ex) {
			System.out.println("Invalid online address");
		}
		catch(WrongPysicalAdress ex) {
			System.out.println("Invalid physical address");
		}
		
		sort(newspaper);
		printInfo(newspaper);
	
		
	}
	
	public static void printInfo(ArrayList<NewspaperSubscription> newspaper) {
	
		for(int i=0; i<newspaper.size();i++) {
			System.out.println(newspaper.get(i).toString());
		}
		
    }
	
	public static void sort(ArrayList<NewspaperSubscription> newspaper) {
		for(int i=0; i<newspaper.size()-1;i++) {
			for(int j=i+1; j<newspaper.size();j++) {
				if(newspaper.get(i).compareTo(newspaper.get(j))>0) {
					NewspaperSubscription temp= newspaper.get(i);
					newspaper.set(i, newspaper.get(j));
					newspaper.set(j, temp);
				}
				
			}
		}
		
	}
	
	
}
