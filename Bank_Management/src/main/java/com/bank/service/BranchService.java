package com.bank.service;

import java.util.Scanner;
import com.bank.dao.BranchDao;
import com.bank.dao.BankDao;
import com.bank.dto.Branch;
import com.bank.dto.Bank;

public class BranchService {

    Scanner sc = new Scanner(System.in);
    BranchDao branchDao = new BranchDao();
    BankDao bankDao = new BankDao();

    public void menu() {
        while (true) {
            System.out.println("---- BRANCH MENU ----");
            System.out.println("1. Create Branch");
            System.out.println("2. View All Branches");
            System.out.println("3. Update Branch");
            System.out.println("4. Delete Branch");
            System.out.println("5. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Branch branch = new Branch();
                    System.out.println("Enter Branch Location:");
                    branch.setLocation(sc.next());

                    System.out.println("Enter Bank ID:");
                    int bankId = sc.nextInt();
                    Bank bank = bankDao.getBankById(bankId);

                    if (bank != null) {
                        branch.setBank(bank);
                        branchDao.saveBranch(branch);
                    } else {
                        System.out.println("Bank not found");
                    }
                    break;

                case 2:
                    branchDao.getAllBranches()
                            .forEach(b -> System.out.println(b.getId() + " " + b.getLocation()));
                    break;

                case 3:
                    System.out.println("Enter Branch ID:");
                    int id = sc.nextInt();

                    Branch b = new Branch();
                    b.setId(id);

                    System.out.println("Enter New Location:");
                    b.setLocation(sc.next());

                    branchDao.updateBranch(b);
                    break;

                case 4:
                    System.out.println("Enter Branch ID:");
                    branchDao.deleteBranch(sc.nextInt());
                    break;

                case 5:
                    return;
            }
        }
    }
}