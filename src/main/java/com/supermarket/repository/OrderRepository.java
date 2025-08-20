package com.supermarket.repository;

import com.supermarket.entity.Order;
import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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


    //Krijo  List qe te besh ruajtje
   //return s.createQuery("from Product", Product.class).list();


    public List<Order> lexoOrders() {
        Transaction t = null;
        List<Order> orders = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            orders = s.createQuery("from Order", Order.class).list();
            t.commit();


            for (Order o : orders) {
                System.out.println(o);
            }

        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
        return orders;
    }





}

