package com.devsuperior.ds_order_system.services;

import com.devsuperior.ds_order_system.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    private double FREE_SHIPPING_ORDER_VALUE = 200.0;
    private double MIN_VALUE_FOR_SHIPPING_DISCOUNT = 100.0;
    public Order shipment(Order order) {
        double orderPrice = order.getBasic();

        if (orderPrice > FREE_SHIPPING_ORDER_VALUE) { return order; }

        if (orderPrice < MIN_VALUE_FOR_SHIPPING_DISCOUNT) {
            order.setBasic(orderPrice + 20.0);
        } else {
            order.setBasic(orderPrice + 12.0);
        }

        return order;
    }

}