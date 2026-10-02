package lab_3.service;

import lab_3.aop.Cacheable;
import lab_3.model.Order;

public class OrderService {


    @Cacheable
    public Order getOrder(String id) {
        System.out.println("(DB hit) loading order " + id);
        return new Order(id, "NEW");
    }

}
