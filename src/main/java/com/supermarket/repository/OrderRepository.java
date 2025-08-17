package com.supermarket.repository;

import com.supermarket.entity.Customer;
import com.supermarket.entity.Order;
import com.supermarket.entity.Product;
import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderRepository {


    public void shtoOrder(Order o){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(o);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }




    public void updateOrder(Order order){

        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.update(order);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }

    public void fshiOrder(Order or){

        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.delete(or);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();
        }
    }




}

