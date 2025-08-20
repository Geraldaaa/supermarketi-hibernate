package com.supermarket.repository;

import com.supermarket.entity.Customer;
import com.supermarket.entity.Order;
import com.supermarket.entity.OrderItem;
import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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



    public List<OrderItem> lexoOrderItems() {
        Transaction t = null;
        List<OrderItem> items = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            items = s.createQuery("from OrderItem", OrderItem.class).list();
            t.commit();


            for (OrderItem o : items) {
                System.out.println(o);
            }

        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
        return items;
    }
}





