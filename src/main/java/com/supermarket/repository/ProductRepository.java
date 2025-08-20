package com.supermarket.repository;

import com.supermarket.entity.Customer;
import com.supermarket.entity.OrderItem;
import com.supermarket.entity.Product;

import com.supermarket.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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



    public List<Product> lexoProduct() {
        Transaction t = null;
        List<Product> p = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            p = s.createQuery("from Product", Product.class).list();
            t.commit();


            for (Product product : p) {
                System.out.println(product);
            }

        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
        return p;
    }
}
