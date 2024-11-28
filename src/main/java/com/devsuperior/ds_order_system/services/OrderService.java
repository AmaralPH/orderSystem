package com.devsuperior.ds_order_system.services;

import com.devsuperior.ds_order_system.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Order total(Order order) {
        order.setBasic(order.getBasic() * (1 - (order.getDiscount()/100)));
        return order;
    }

}
