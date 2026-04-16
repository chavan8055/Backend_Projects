package com.bank.service;

import java.util.Scanner;
import com.bank.dao.CustomerDao;
import com.bank.dao.BranchDao;
import com.bank.dto.Customer;
import com.bank.dto.Branch;

public class CustomerService {

    Scanner sc = new Scanner(System.in);
    CustomerDao customerDao = new CustomerDao();
    BranchDao branchDao = new BranchDao();

    public void menu() {
        while (true) {
            System.out.println("---- CUSTOMER MENU ----");
            System.out.println("1. Create Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Customer c = new Customer();
                    System.out.println("Enter Customer Name:");
                    c.setName(sc.next());

                    System.out.println("Enter Branch ID:");
                    int branchId = sc.nextInt();
                    Branch branch = branchDao.getBranchById(branchId);

                    if (branch != null) {
                        c.setBranch(branch);
                        customerDao.saveCustomer(c);
                    } else {
                        System.out.println("Branch not found");
                    }
                    break;

                case 2:
                    customerDao.getAllCustomers()
                            .forEach(x -> System.out.println(x.getId() + " " + x.getName()));
                    break;

                case 3:
                    System.out.println("Enter Customer ID:");
                    int id = sc.nextInt();

                    Customer cust = new Customer();
                    cust.setId(id);

                    System.out.println("Enter New Name:");
                    cust.setName(sc.next());

                    customerDao.updateCustomer(cust);
                    break;

                case 4:
                    System.out.println("Enter Customer ID:");
                    customerDao.deleteCustomer(sc.nextInt());
                    break;

                case 5:
                    return;
            }
        }
    }
}