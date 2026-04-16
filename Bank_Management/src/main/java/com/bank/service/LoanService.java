package com.bank.service;

import java.util.*;
import com.bank.dao.LoanDao;
import com.bank.dao.BranchDao;
import com.bank.dao.CustomerDao;
import com.bank.dto.Loan;
import com.bank.dto.Branch;
import com.bank.dto.Customer;

public class LoanService {

    Scanner sc = new Scanner(System.in);
    LoanDao loanDao = new LoanDao();
    BranchDao branchDao = new BranchDao();
    CustomerDao customerDao = new CustomerDao();

    public void menu() {
        while (true) {
            System.out.println("---- LOAN MENU ----");
            System.out.println("1. Create Loan");
            System.out.println("2. View All Loans");
            System.out.println("3. Update Loan");
            System.out.println("4. Delete Loan");
            System.out.println("5. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Loan loan = new Loan();
                    System.out.println("Enter Loan Amount:");
                    loan.setAmount(sc.nextDouble());

                    System.out.println("Enter Branch ID:");
                    int branchId = sc.nextInt();
                    Branch branch = branchDao.getBranchById(branchId);

                    if (branch != null) {
                        loan.setBranch(branch);

                        // Many-to-Many (Customer ↔ Loan)
                        System.out.println("Enter Customer ID:");
                        Customer customer = customerDao.getCustomerById(sc.nextInt());

                        if (customer != null) {
                            loan.setCustomers(Arrays.asList(customer));
                            loanDao.saveLoan(loan);
                        } else {
                            System.out.println("Customer not found");
                        }
                    } else {
                        System.out.println("Branch not found");
                    }
                    break;

                case 2:
                    loanDao.getAllLoans()
                            .forEach(l -> System.out.println(l.getId() + " " + l.getAmount()));
                    break;

                case 3:
                    System.out.println("Enter Loan ID:");
                    int id = sc.nextInt();

                    Loan l = new Loan();
                    l.setId(id);

                    System.out.println("Enter New Amount:");
                    l.setAmount(sc.nextDouble());

                    loanDao.updateLoan(l);
                    break;

                case 4:
                    System.out.println("Enter Loan ID:");
                    loanDao.deleteLoan(sc.nextInt());
                    break;

                case 5:
                    return;
            }
        }
    }
}