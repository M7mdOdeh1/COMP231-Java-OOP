package finalproject;

import java.util.ArrayList;


public class Customer {
	
	protected String id;
	protected String name;
	protected String address;
	protected String plan;
	protected String mobile;
	protected ArrayList<String> cart = new ArrayList<>();  //this list represent the media the customer is interested in receiving
	protected ArrayList<String> rented = new ArrayList<>();  //this list represents the media already received by the customer
	
	
	public Customer(String id, String name, String address, String plan, String mobile) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		
		String p = plan.toUpperCase();
		if(p.equals("LIMITED") || p.equals("UNLIMITED")) 
			this.plan = plan.toUpperCase();
		else
			throw new IllegalArgumentException("plan must be LIMITED or UNLIMITED");
		
	}
	
	

	public Customer(String id, String name, String address, String plan,String mobile, ArrayList<String> cart, ArrayList<String> rented) {
		super();
		this.id=id;
		this.name = name;
		this.address = address;
		this.mobile=mobile;
		this.cart = cart;
		this.rented = rented;
		
		String p = plan.toUpperCase();
		if(p.equals("LIMITED") || p.equals("UNLIMITED")) 
			this.plan = plan.toUpperCase();
		else
			throw new IllegalArgumentException("plan must be LIMITED or UNLIMITED");
		
		
	}




	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
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
		
		String p = plan.toUpperCase();
		if(p.equals("LIMITED") || p.equals("UNLIMITED")) 
			this.plan = plan.toUpperCase();
		else
			throw new IllegalArgumentException("plan must be LIMITED or UNLIMITED");
		
	}

	

	public ArrayList<String> getCart() {
		return cart;
	}


	public ArrayList<String> getRented() {
		return rented;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", plan=" + plan + ", mobile="
				+ mobile + ", cart=" + cart + ", rented=" + rented + "]";
	}


	

	
	
	
	

}
