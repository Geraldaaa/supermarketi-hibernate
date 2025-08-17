package com.supermarket.repository;

import com.supermarket.entity.Customer;
import com.supermarket.entity.Product;

import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductRepository {

    public void save(Product p){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(p);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }



    public void updateProduct(Product product){

        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.update(product);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }



    public void fshiProdukt(Product p){

        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.delete(p);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback();
            e.printStackTrace();}
    }

}
