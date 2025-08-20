package com.supermarket.repository;

import com.supermarket.entity.Customer;
import com.supermarket.entity.OrderItem;
import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerRepository {



    public void shtoCustomer(Customer c){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(c);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }



    public void updateCustomer(Customer c){

        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.update(c);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }


    public void deleteCustomer(Customer c){

        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.delete(c);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }




    public List<Customer> lexoCustomer() {
        Transaction t = null;
        List<Customer> customer = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            customer = s.createQuery("from Customer", Customer.class).list();
            t.commit();

            for (Customer o : customer) {
                System.out.println(o);
            }

        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
        return customer;
    }
}
