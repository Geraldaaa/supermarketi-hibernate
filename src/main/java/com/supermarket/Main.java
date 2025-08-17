package com.supermarket;

import com.supermarket.entity.Customer;
import com.supermarket.entity.Order;
import com.supermarket.entity.OrderItem;
import com.supermarket.entity.Product;
import com.supermarket.repository.CustomerRepository;
import com.supermarket.repository.OrderItemRepository;
import com.supermarket.repository.OrderRepository;
import com.supermarket.repository.ProductRepository;


public class Main {
    public static void main(String[] args) {


        Product p6 = new Product("kos", 100.0,1000,"ushqim");
        ProductRepository pr = new ProductRepository();
       // pr.save(p6);

        Customer c4 = new Customer("Ani","ani@gmail.com","0696069000","Librazhd");
        CustomerRepository cr = new CustomerRepository();
        cr.shtoCustomer(c4);
        c4.setEmail("aniUpdate@gmail.com");
        cr.updateCustomer(c4);

        Order o3 = new Order(c4);
        OrderRepository or = new OrderRepository();
      //  or.shtoOrder(o3);

        OrderItem item2 = new OrderItem(o3,p6,6,800.0);
        OrderItemRepository oires = new OrderItemRepository();
       // oires.shtoItems(item2);



    }
}