package com.bank.dto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Loan {

    @Id
    @GeneratedValue
    private int id;
    private double amount;

    @ManyToOne
    @JoinColumn
    private Branch branch;

    @ManyToMany(mappedBy = "loans")
    private List<Customer> customers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

    // getters & setters
    
}