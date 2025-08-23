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


        ProductRepository pr = new ProductRepository();
        CustomerRepository cr = new CustomerRepository();
        OrderRepository or = new OrderRepository();
        OrderItemRepository oi = new OrderItemRepository();


        Product p1 = new Product("Uje", 50.0, 100, "Pije");
        Product p2 = new Product("Kastravec", 60.0, 500, "Ushqim");
        pr.save(p1);
        pr.save(p2);

        Customer c1 = new Customer("Geralda", "geralda@gmail.com", "0696069999", "Durres");
        cr.shtoCustomer(c1);

        Order o1 = new Order(c1);
        or.shtoOrder(o1);

        OrderItem item1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem item2 = new OrderItem(o1, p2, 3, p2.getPrice());
        oi.shtoItems(item1);
        oi.shtoItems(item2);
        oi.lexoOrderItems();


        System.out.println("--- Porositë ---");
        or.lexoOrders();




    }
}
