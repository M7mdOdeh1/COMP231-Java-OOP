package finalproject;

import java.util.ArrayList;

public interface MediaRentalInt {
	
	void addCustomer(String id, String name,String address,String plan, String mobile);
	void addMovie(String code, String title, int copiesAvailable,String rating);
	void addGame(String code, String title, int copiesAvailable,double weight);
	void addAlbum(String code, String title,int copiesAvailable,String artist,String songs);
	
	void setLimitedPlanLimit(int value);
	
	String getAllCustomersInfo();
	String getAllMediaInfo();
	
	boolean addToCart(String id,String code);
	boolean removeFromCart(String id, String code);
	
	String processRequests(String customerId);
	
	boolean returnMedia(String id,String code);
	ArrayList<String> searchMedia(String title,String rating, String artist,String songs);

}
