package com.bank.dao;

import javax.persistence.*;
import java.util.List;
import com.bank.dto.Loan;

public class LoanDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("akanksha");

    public void saveLoan(Loan loan) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(loan);
        et.commit();
    }

    public List<Loan> getAllLoans() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Loan", Loan.class).getResultList();
    }

    public Loan getLoanById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Loan.class, id);
    }

    public void updateLoan(Loan loan) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(loan);
        et.commit();
    }

    public void deleteLoan(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Loan loan = em.find(Loan.class, id);
        if (loan != null) {
            et.begin();
            em.remove(loan);
            et.commit();
        } else {
            System.out.println("Loan not found");
        }
    }
}