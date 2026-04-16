package com.bank.dao;

import javax.persistence.*;
import java.util.List;
import com.bank.dto.Branch;

public class BranchDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("akanksha");

    public void saveBranch(Branch branch) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(branch);
        et.commit();
    }

    public List<Branch> getAllBranches() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Branch", Branch.class).getResultList();
    }

    public Branch getBranchById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Branch.class, id);
    }

    public void updateBranch(Branch branch) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(branch);
        et.commit();
    }

    public void deleteBranch(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Branch branch = em.find(Branch.class, id);
        if (branch != null) {
            et.begin();
            em.remove(branch);
            et.commit();
        } else {
            System.out.println("Branch not found");
        }
    }
}