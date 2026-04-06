package com.qsp;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        createAccount ca = new createAccount();
        login lg = new login();
        deposit dp = new deposit();
        withdraw wd = new withdraw();
        checkBalance cb = new checkBalance();
        transactionHistory th = new transactionHistory();

        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();

                    ca.createAccount(name, email, pass);
                    break;

                case 2:
                    System.out.print("Enter Email: ");
                    String em = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String ps = sc.nextLine();

                    int userId = lg.login(em, ps);

                    if (userId == -1) {
                        System.out.println("Invalid Login");
                        break;
                    }

                    System.out.println("Login Successful");

                    while (true) {
                        System.out.println("\n--- USER MENU ---");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. Transaction History");
                        System.out.println("5. Logout");

                        int ch = sc.nextInt();
                        sc.nextLine(); // ✅ clear buffer

                        switch (ch) {
                            case 1:
                                System.out.print("Enter Amount: ");
                                double amt = sc.nextDouble();
                                sc.nextLine();
                                dp.deposit(userId, amt);
                                break;

                            case 2:
                                System.out.print("Enter Amount: ");
                                double amt2 = sc.nextDouble();
                                sc.nextLine();
                                wd.withdraw(userId, amt2);
                                break;

                            case 3:
                                cb.checkBalance(userId);
                                break;

                            case 4:
                                th.transactionHistory(userId);
                                break;

                            case 5:
                                System.out.println("Logged Out");
                                break;

                            default:
                                System.out.println("Invalid Choice");
                        }

                        if (ch == 5) break;
                    }
                    break;

                case 3:
                    System.out.println("Thank You");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}