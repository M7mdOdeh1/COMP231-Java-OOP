package finalproject;

import java.util.ArrayList;
import java.util.Collections;

import javax.management.openmbean.KeyAlreadyExistsException;

public class MediaRental implements MediaRentalInt {

	protected int limit;
	protected ArrayList<Customer> customer = new ArrayList<>();
	protected ArrayList<Media> media = new ArrayList<>();
	

	public MediaRental() {
		limit =2;
	}
	

	public ArrayList<Customer> getCustomer() {
		return customer;
	}

	public ArrayList<Media> getMedia() {
		return media;
	}

	public void addCustomer(String name,String address,String plan) {
		if(isCustomerExist(name)) {  //throw exception if customer name is already exist in  the customer list
			throw new KeyAlreadyExistsException("This username is already taken, try another one");
		}
		else 
			customer.add(new Customer(name, address, plan));
		
	}
	
	public void addMovie(String title, int copiesAvailable,String rating) {
		if(isMediaExist(title)) { //throw exception if mediaTitle is already exist in the media list 
			throw new KeyAlreadyExistsException("This mediaTitle is exist taken, try another one");
		}
		else
			media.add(new Movie(title, copiesAvailable, rating));
	}
	
	public void addGame(String title, int copiesAvailable,double weight) {
		if(isMediaExist(title)) { //throw exception if mediaTitle is already exist in the media list 
			throw new KeyAlreadyExistsException("This mediaTitle is exist taken, try another one");
		}
		else
			media.add(new Game(title, copiesAvailable, weight));
	}
	
	public void addAlbum(String title,int copiesAvailable,String artist,String songs) {
		
		if(isMediaExist(title)) { //throw exception if mediaTitle is already exist in the media list 
			throw new KeyAlreadyExistsException("This mediaTitle is exist taken, try another one");
		}
		else
			media.add(new Album(title, copiesAvailable, artist, songs));
	}
	
	public void setLimitedPlanLimit(int value) {
		if(value<=0)
			throw new IllegalArgumentException("limit cannot be zero or negative");
		else
			limit=value;
	}
	
	
	public String getAllCustomersInfo() {	
		                                                     //sort using comparator by the customer name
		Collections.sort(customer, new SortCustomerByName()); //SortCustomerByName class found in ComparatorSort.java
		StringBuilder sb = new StringBuilder("");
		
		
		for(int i=0; i<customer.size(); i++) {
			sb.append(customer.get(i).toString() + "\n");
		}
		return sb.toString();
	}
	
	
	
	
	public String getAllMediaInfo() {
                                                   		//sort using comparator by media titles
		Collections.sort(media, new SortMediaByTitle()); //SortMediaByTitle class found in ComparatorSort.java
		StringBuilder sb = new StringBuilder("");

		for(int i=0; i<media.size(); i++) {
			sb.append(media.get(i).toString() + "\n");
		}
		return sb.toString();
	}
	
	
	public boolean addToCart(String customerName,String mediaTitle) {
		  		  
		  if(!isMediaExist(mediaTitle))          //return false if media title not exist
			  return false;
		  
		  for(int i=0; i<customer.size(); i++) {   
			  Customer c= customer.get(i);
			  if(c.getName().equals(customerName)) {   //find the customer to add the media title in his cart
				  for(int j=0; j < c.getCart().size() ; j++) {   //check if media title is already in the cart
					  if(c.getCart().get(j).equals(mediaTitle)) 
						  return false;                          			  
				  }
				  
				  c.getCart().add(mediaTitle);  //add the media title to the cart
				  return true;
			  }			
		  }
		  
		  return false;   // this will return false if customer name not found
	  }
	  
	
	  public boolean removeFromCart(String customerName, String mediaTitle) {
		  
		  if(!isMediaExist(mediaTitle))
			  return false;    //return false if media title not exist
		  
		  for(int i=0; i < customer.size(); i++) {    //find the customer to remove the media title from his cart
			  Customer c= customer.get(i);
			  if(c.getName().equals(customerName)) 
				  return c.getCart().remove(mediaTitle); //remove the media title from the cart and return true 		  
		  }                                             //if the list contains the media title and return false if not
				
			  return false;   // this will return false if customer name not found
	  }
		  
	  
	  
	  public String processRequests() {  //move the media from cart to rented list after check the conditions
		  Collections.sort(customer, new SortCustomerByName());  //sort customers by names
		  StringBuilder sb= new StringBuilder("");
		  
		  for(int i=0; i < customer.size(); i++) {  
			  Customer c= customer.get(i);
			//  System.out.println(c.getCart().size());
		
				  for(int j=0; j<c.getCart().size(); j++) {
					  int index= indexOfMediaTitle(c.getCart().get(j)); 
					//  System.out.println(index);
							  if(media.get(index).getNo_of_copies() > 0 ) {  
								  if(c.getPlan().equals("UNLIMITED")) {	  
									  c.getRented().add(c.getCart().get(j));
									  sb.append("sending ["+c.getCart().get(j)+"] to ["+c.getName()+"]\n");
									  c.getCart().remove(j);
									  media.get(index).setNo_of_copies(media.get(index).getNo_of_copies()-1);
								  }  
								  else if(c.getPlan().equals("LIMITED")) {
									  if(c.getRented().size() < limit) {
										  c.getRented().add(c.getCart().get(j));
										  sb.append("sending ["+c.getCart().get(j)+"] to ["+c.getName()+"]\n");
										  c.getCart().remove(j);
										  media.get(index).setNo_of_copies(media.get(index).getNo_of_copies()-1);
										  
									  }
									  else if(c.getRented().size()==2)
										  sb.append("faild to send ["+c.getCart().get(j)+"] to ["+c.getName()+"] , "
										  		+ "You have reached your Renting limit, upgrade your plan to get more media");
							  }
								  
							  }
						  else if(media.get(index).getNo_of_copies() == 0)//check if there are no copies available
							  sb.append("faild to send ["+c.getCart().get(j)+"] to ["+c.getName()+"] , there are no copy available\n");
					  					  

				  }
			  
		  }
		  
		  return sb.toString();
	  }
	  public boolean returnMedia(String customerName,String mediaTitle) { //return the media from rented list to the system
		  if(!isMediaExist(mediaTitle))
				  return false;    //return false if media Title not exist
		  
		  int index=indexOfMediaTitle(mediaTitle);

		  for(int i=0; i<customer.size(); i++) {
			  Customer c= customer.get(i);
			  if(c.getName().equals(customerName)) {
				  for(int j=0; j<c.getRented().size(); j++) {
					  if(c.getRented().get(j).equals(mediaTitle)) {
						  c.getRented().remove(j);
						  media.get(index).setNo_of_copies(media.get(index).getNo_of_copies()+1);
						  return true;
					  }
				  }
				  return false;  //return false if the media title is not in the rented list
				  
					 
			  }
		  }

		  		  
		  return false;  //return false if customer not fount
	  }
	  
	  
	//search for media according to specific  parameters
	  public ArrayList<String> searchMedia(String title,String rating, String artist,String songs){
		  title=title.toUpperCase();
		  rating=rating.toUpperCase();
		  artist=artist.toUpperCase();
		  songs=songs.toUpperCase();
		  ArrayList<String> result=new ArrayList<>();
		  
		  for(int i=0; i<media.size(); i++) {
			  if(media.get(i) instanceof Album) {   //search in Album Objects
				  if(rating.equals("")) {  //if rating is provided skip this object (Album doesn't contain rating)
					  if(media.get(i).getTitle().toUpperCase().equals(title) || title.equals("") ) {
						  if(((Album)media.get(i)).getArtist().toUpperCase().equals(artist) || artist .equals("")) {
							  if(((Album)media.get(i)).getSongs().toUpperCase().indexOf(songs)>=0 ) {
								  result.add(media.get(i).getTitle());								  
							  }
						  }
					  }
				  }
			  }
			  
			  else if(media.get(i) instanceof Movie) {  //search in Movie Objects
				  if(artist.equals("") && songs.equals("")) { //if artist or songs is provided skip this object(movie doesn't contain them)
					  if(media.get(i).getTitle().toUpperCase().equals(title) || title .equals("")) {
						  if(((Movie)media.get(i)).getRating().toUpperCase().equals(rating) || rating .equals("")) {
							  result.add(media.get(i).getTitle());								  
						  }
					  }
				  }	  
			  }
			  
			  else if(media.get(i) instanceof Game) { //search in Game Objects
				  if(artist.equals("") && songs.equals("") && rating.equals("")) { //if artist and song and rating is provided skip this Objects
					  if(media.get(i).getTitle().toUpperCase().equals(title) || title .equals("")) {
						  result.add(media.get(i).getTitle());								  
					  }
				  }
			  }
			  
			  
		  }
		  
		  Collections.sort(result);
		  return result;		
	  }
	 
	
	  
	  private boolean isMediaExist(String mediaTitle) { //check if media title is exist in the media list
		  boolean temp= false;
		  
		  
		  for(int i=0; i < media.size(); i++)     
			 if(media.get(i).getTitle().equals(mediaTitle)){
				 temp=true;
				 break; 
			 }
		  
		  return temp;
	  }
	  
	  
	  private int indexOfMediaTitle(String mediaTitle) {   //return the index of the given media title from the media list
		  for(int i=0; i<media.size(); i++) {
			  if(media.get(i).getTitle().equals(mediaTitle))
				  return i;
		  }
		  
		  return -1;
	  }
	  
	  
		
		private boolean isCustomerExist(String customerName) { //check if customer  name is exist in the customer list
		  boolean temp= false;
		  
		  for(int i=0; i < customer.size(); i++)
		  if(customer.get(i).getName().equals(customerName)){ temp=true; break; }
		  
		  return temp; 
		  }
	  
	
	
		
}
