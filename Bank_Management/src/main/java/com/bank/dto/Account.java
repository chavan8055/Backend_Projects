package com.bank.dto;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private int id;
    private double balance;

    @ManyToOne
    @JoinColumn
    private Customer customer;

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    // getters & setters
    
    
}