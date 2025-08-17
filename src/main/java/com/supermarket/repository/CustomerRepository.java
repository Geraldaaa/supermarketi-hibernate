package com.supermarket.repository;

import com.supermarket.entity.Customer;
import com.supermarket.entity.Product;
import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
            s.merge(c);
            s.update(c);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }

}
