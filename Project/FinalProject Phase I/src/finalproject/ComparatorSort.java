package finalproject;

import java.util.Comparator;

 class SortMediaByTitle implements Comparator<Media> { //compare two media by their titles  
	
	public int compare(Media o1, Media o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}

 class SortCustomerByName implements Comparator<Customer>{  //compare two customer by their names
	 
	 public int compare(Customer o1, Customer o2) {
			return o1.getName().compareTo(o2.getName());
		}

	
}
