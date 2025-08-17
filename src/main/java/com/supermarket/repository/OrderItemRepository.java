package com.supermarket.repository;

import com.supermarket.entity.Customer;
import com.supermarket.entity.OrderItem;
import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderItemRepository {

    public void shtoItems(OrderItem oi){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(oi);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }



    public void updateOrderItems(OrderItem item){

        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.update(item);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }

    public void fshiOrderItem(OrderItem item){

        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.delete(item);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }
}





