package com.bank.dto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Branch {

    @Id
    @GeneratedValue
    private int id;
    private String location;

    @ManyToOne
    @JoinColumn
    private Bank bank;

    @OneToMany(mappedBy = "branch")
    private List<Customer> customers;

    @OneToMany(mappedBy = "branch")
    private List<Loan> loans;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

    // getters & setters
    
}