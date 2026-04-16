package com.bank.dao;

import javax.persistence.*;
import java.util.List;
import com.bank.dto.Account;

public class AccountDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("akanksha");
    

    public void saveAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        

        et.begin();
        em.persist(account);
        et.commit();
       
    }

    public List<Account> getAllAccounts() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Account", Account.class).getResultList();
        
    }

    public Account getAccountById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Account.class, id);
    }

    public void updateAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(account);
        et.commit();
    }

    public void deleteAccount(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Account account = em.find(Account.class, id);
        if (account != null) {
            et.begin();
            em.remove(account);
            et.commit();
        } else {
            System.out.println("Account not found");
        }
    }
   
}