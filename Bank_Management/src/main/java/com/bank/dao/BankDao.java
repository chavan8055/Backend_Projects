package com.bank.dao;

import javax.persistence.*;
import java.util.List;
import com.bank.dto.Bank;

public class BankDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("akanksha");

    public void saveBank(Bank bank) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(bank);
        et.commit();
    }

    public List<Bank> getAllBanks() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Bank", Bank.class).getResultList();
    }

    // 🔥 ADD THIS METHOD (VERY IMPORTANT)
    public Bank getBankById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Bank.class, id);
    }

    public void updateBank(Bank bank) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(bank);
        et.commit();
    }

    public void deleteBank(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Bank bank = em.find(Bank.class, id);
        if (bank != null) {
            et.begin();
            em.remove(bank);
            et.commit();
        }
    }
}