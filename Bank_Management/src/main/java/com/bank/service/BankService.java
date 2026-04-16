package com.bank.service;

import java.util.Scanner;
import com.bank.dao.BankDao;
import com.bank.dto.Bank;

public class BankService {

    Scanner sc = new Scanner(System.in);
    BankDao dao = new BankDao();

    public void menu() {
        while (true) {
            System.out.println("---- BANK MENU ----");
            System.out.println("1. Create Bank");
            System.out.println("2. View All Banks");
            System.out.println("3. Update Bank");
            System.out.println("4. Delete Bank");
            System.out.println("5. Back");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Bank b = new Bank();
                    System.out.println("Enter Bank Name:");
                    b.setName(sc.next());
                    dao.saveBank(b);
                    break;

                case 2:
                    dao.getAllBanks().forEach(x -> System.out.println(x.getName()));
                    break;

                case 3:
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    Bank bank = new Bank();
                    bank.setId(id);
                    System.out.println("Enter New Name:");
                    bank.setName(sc.next());
                    dao.updateBank(bank);
                    break;

                case 4:
                    System.out.println("Enter ID:");
                    dao.deleteBank(sc.nextInt());
                    break;

                case 5:
                    return;
            }
        }
    }
}