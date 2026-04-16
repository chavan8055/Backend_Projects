package com.bank.service;

import java.util.Scanner;
import com.bank.dao.AccountDao;
import com.bank.dao.CustomerDao;
import com.bank.dto.Account;
import com.bank.dto.Customer;

public class AccountService {

    Scanner sc = new Scanner(System.in);
    AccountDao accountDao = new AccountDao();
    CustomerDao customerDao = new CustomerDao();

    public void menu() {
        while (true) {
            System.out.println("---- ACCOUNT MENU ----");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Update Account");
            System.out.println("4. Delete Account");
            System.out.println("5. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Account acc = new Account();
                    System.out.println("Enter Balance:");
                    acc.setBalance(sc.nextDouble());
                    

                    System.out.println("Enter Customer ID:");
                    Customer customer = customerDao.getCustomerById(sc.nextInt());

                    if (customer != null) {
                        acc.setCustomer(customer);
                        accountDao.saveAccount(acc);
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;

                case 2:
                    accountDao.getAllAccounts()
                            .forEach(a -> System.out.println(a.getId() + " " + a.getBalance()));
                    break;

                case 3:
                    System.out.println("Enter Account ID:");
                    int id = sc.nextInt();

                    Account a = new Account();
                    a.setId(id);

                    System.out.println("Enter New Balance:");
                    a.setBalance(sc.nextDouble());

                    accountDao.updateAccount(a);
                    break;

                case 4:
                    System.out.println("Enter Account ID:");
                    accountDao.deleteAccount(sc.nextInt());
                    break;

                case 5:
                    return;
            }
        }
    }
}