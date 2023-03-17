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

	public void addCustomer(String id, String name,String address,String plan, String mobile) {
		if(isCustomerExist(id)) {  //throw exception if customer id is already exist in  the customer list
			throw new KeyAlreadyExistsException("This id is already taken, try another one");
		}
		else 
			customer.add(new Customer(id, name, address, plan, mobile));
		
	}
	
	public void addMovie(String code, String title, int copiesAvailable,String rating) {
		if(isMediaExist(code)) { //throw exception if mediaTitle is already exist in the media list 
			throw new KeyAlreadyExistsException("This code is exist taken, try another one");
		}
		else
			media.add(new Movie(code, title, copiesAvailable, rating));
	}
	
	public void addGame(String code, String title, int copiesAvailable,double weight) {
		if(isMediaExist(code)) { //throw exception if mediaTitle is already exist in the media list 
			throw new KeyAlreadyExistsException("This code is exist taken, try another one");
		}
		else
			media.add(new Game(code, title, copiesAvailable, weight));
	}
	
	public void addAlbum(String code, String title,int copiesAvailable,String artist,String songs) {
		
		if(isMediaExist(code)) { //throw exception if mediaTitle is already exist in the media list 
			throw new KeyAlreadyExistsException("This code is exist taken, try another one");
		}
		else
			media.add(new Album(code, title, copiesAvailable, artist, songs));
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
	
	
	public boolean addToCart(String id,String code) {
		  		  
		  if(!isMediaExist(code))          //return false if media code not exist
			  return false;
		  
		 int i = searchCustomerById(id);
			  Customer c= customer.get(i);
			  
			  if(i != -1) {
				  
				  for(int j=0; j < c.getCart().size() ; j++) {   //check if media code is already in the cart
					  if(c.getCart().get(j).equals(code)) 
						  return false;                          			  
				  }
				  
				  c.getCart().add(code);  //add the media code to the cart
				  return true;
				  
			  }
				  	  
		  return false;   // this will return false if customer  not found
	  }
	  
	
	  public boolean removeFromCart(String id, String code) {
		  
		  if(!isMediaExist(code))
			  return false;    //return false if media code not exist
		  
		  for(int i=0; i < customer.size(); i++) {    //find the customer to remove the media code from his cart
			  Customer c= customer.get(i);
			  if(c.getId().equals(id)) 
				  return c.getCart().remove(code); //remove the media code from the cart and return true 		  
		  }                                             //if the list contains the media code and return false if not
				
			  return false;   // this will return false if customer id not found
	  }
		  
	  
	  
	  public String processRequests(String cutomerId) {  //move the media from cart to rented list after check the conditions
		  StringBuilder sb = new StringBuilder();
		  int i = searchCustomerById(cutomerId);
		  
		  if(i<0) {
			  return "Customer Not Found";
		  }
		 
				 Customer c= customer.get(i);   
				 
				  while(c.getCart().size() != 0) {
					  int index= indexOfMediaCode(c.getCart().get(0)); 

					  if(media.get(index).getNo_of_copies() > 0 ) {  
								  if(c.getPlan().equals("UNLIMITED")) {	  
									  c.getRented().add(c.getCart().get(0));
									  sb.append("sending [" + media.get(index).getTitle()+"] to ["+c.getName()+"]\n");
									  media.get(index).setNo_of_copies(media.get(index).getNo_of_copies()-1);
								  }  
								  else if(c.getPlan().equals("LIMITED")) {
									  if(c.getRented().size() < limit) {
										  c.getRented().add(c.getCart().get(0));
										  sb.append("sending ["+media.get(index).getTitle()+"] to ["+c.getName()+"]\n");
										  media.get(index).setNo_of_copies(media.get(index).getNo_of_copies()-1);
										  
									  }
									  else if(c.getRented().size()==2)
										  sb.append("faild to send ["+ media.get(index).getTitle() +"] to ["+c.getName()+"]\n"
										  		+ "You have reached your Renting limit\n");
							  }
								  
							  }
						  else if(media.get(index).getNo_of_copies() == 0) {  //check if there are no copies available
							  sb.append("faild to send ["+media.get(index).getTitle()+"] to ["+c.getName()+"]\n"
							  		+ "there are no copy available\n");
						  }
					  
					  c.getCart().remove(0);
					  					  
				  }
			  
		  
		  
		  return sb.toString();
	  }
	  
	  public boolean returnMedia(String id,String code) { //return the media from rented list to the system
		  if(!isMediaExist(code))
				  return false;    //return false if media code not exist
		  
		  int index=indexOfMediaCode(code);

		  for(int i=0; i<customer.size(); i++) {
			  Customer c= customer.get(i);
			  if(c.getId().equals(id)) {
				  for(int j=0; j<c.getRented().size(); j++) {
					  if(c.getRented().get(j).equals(code)) {
						  c.getRented().remove(j);
						  media.get(index).setNo_of_copies(media.get(index).getNo_of_copies()+1);
						  return true;
					  }
				  }
				  return false;  //return false if the media code is not in the rented list
				  
					 
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
	  
	  
	  public int searchCustomerById(String id) { // search for customer by it's id
		  for(int i=0; i<customer.size(); i++) {
			  if(customer.get(i).getId().equals(id))
				  return i;
		  }
		  return -1;
	  }
	  
	  public int searchMediaByCode(String code) { //search for media by it's code
		  for(int i=0; i<media.size(); i++) {
			  if(media.get(i).getCode().equals(code))
				  return i;
		  }
		  
		  return -1;
	  }
	  
	  public boolean deleteCustomer(String id) {  //delete customer by his id
		  int i = searchCustomerById(id);
			if(i != -1) {
				   customer.remove(i);
				   return true;
			}
			  
			  return false;
		  }
	  
	  public boolean deleteMedia(String code) {  //delete the media by it's code 
		  int i = searchMediaByCode(code);
			if(i != -1) {
				   customer.remove(i);
				   return true;
			}
		  
		  return false;
	  }
	  
	  
	  private boolean isMediaExist(String mediaCode) { //check if media code is exist in the media list
		  boolean temp= false;
		  
		  for(int i=0; i < media.size(); i++)     
			 if(media.get(i).getCode().equals(mediaCode)){
				 temp=true;
				 break; 
			 }
		  
		  return temp;
	  }
	  
	  
	  private int indexOfMediaCode(String mediaCode) {   //return the index of the given media code from the media list
		  for(int i=0; i<media.size(); i++) {
			  if(media.get(i).getCode().equals(mediaCode))
				  return i;
		  }
		  
		  return -1;
	  }
	  
	  
		
		private boolean isCustomerExist(String customerId) { //check if customer  name is exist in the customer list
		  boolean temp= false;
		  
		  for(int i=0; i < customer.size(); i++)
		  if(customer.get(i).getId().equals(customerId)){ 
			  temp=true;
			  break;
			  }
		  
		  return temp; 
		  }
	  
	
	
		
}
