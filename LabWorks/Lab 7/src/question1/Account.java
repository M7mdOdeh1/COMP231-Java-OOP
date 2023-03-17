package question1;

import java.util.*;

public class Account {
	private int id;
	private double balance;
	private Date dateCreated;
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.dateCreated=new Date();
	}
	
	public Account() {
		this.id=0;
		this.balance=0;
		this.dateCreated=new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void Withdraw(double amount) {
		balance -= amount;
	}
	
	public void Deposit(double amount) {
		balance += amount;
	}

	 boolean Equals(Object obj) {
		return this.getBalance()==((Checking)obj).getBalance();
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", dateCreated=" + dateCreated + "]";
	}
	
	
	
	
	
	

	
}
