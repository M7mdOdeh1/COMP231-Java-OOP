package finalproject;

import java.util.ArrayList;


public class Customer {
	
	protected String name;
	protected String address;
	protected String plan;
	protected ArrayList<String> cart = new ArrayList<>();  //this list represent the media the customer is interested in receiving
	protected ArrayList<String> rented = new ArrayList<>();  //this list represents the media already received by the customer
	
	
	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		
		String p = plan.toUpperCase();
		if(p.equals("LIMITED") || p.equals("UNLIMITED")) 
			this.plan = plan.toUpperCase();
		else
			throw new IllegalArgumentException("plan must be LIMITED or UNLIMITED");
		
	}
	
	

	public Customer(String name, String address, String plan, ArrayList<String> cart, ArrayList<String> rented) {
		super();
		this.name = name;
		this.address = address;
		this.cart = cart;
		this.rented = rented;
		
		String p = plan.toUpperCase();
		if(p.equals("LIMITED") || p.equals("UNLIMITED")) 
			this.plan = plan.toUpperCase();
		else
			throw new IllegalArgumentException("plan must be LIMITED or UNLIMITED");
		
		
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPlan() {
		return plan;
	}


	public void setPlan(String plan) {
		this.plan = plan.toUpperCase();
	}

	

	public ArrayList<String> getCart() {
		return cart;
	}


	public ArrayList<String> getRented() {
		return rented;
	}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", plan=" + plan + ", cart=" + cart + ", rented items ="
				+ rented + "]";
	}

	
	
	
	

}
