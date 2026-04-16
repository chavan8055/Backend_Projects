package com.bank.main;

import java.util.Scanner;
import com.bank.service.*;

public class BankDriver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankService bankService = new BankService();
        BranchService branchService = new BranchService();
        CustomerService customerService = new CustomerService();
        LoanService loanService = new LoanService();
        AccountService accountService = new AccountService();

        while (true) {
            System.out.println("1. MANAGE BANK");
            System.out.println("2. MANAGE BRANCH");
            System.out.println("3. MANAGE CUSTOMER");
            System.out.println("4. MANAGE LOAN");
            System.out.println("5. MANAGE ACCOUNT");
            System.out.println("6. EXIT");
            System.out.println("Enter Your Choice : ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: bankService.menu();
                break;
                case 2: branchService.menu(); 
                break;
                case 3: customerService.menu(); 
                break;
                case 4: loanService.menu(); 
                break;
                case 5: accountService.menu(); 
                break;
                case 6: System.exit(0);
            }
        }
    }
}