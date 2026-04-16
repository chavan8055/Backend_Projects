package com.bank.dao;

import javax.persistence.*;
import java.util.List;
import com.bank.dto.Customer;

public class CustomerDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("akanksha");

    public void saveCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(customer);
        et.commit();
    }

    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    public Customer getCustomerById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    public void updateCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(customer);
        et.commit();
    }

    public void deleteCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Customer customer = em.find(Customer.class, id);
        if (customer != null) {
            et.begin();
            em.remove(customer);
            et.commit();
        } else {
            System.out.println("Customer not found");
        }
    }
}