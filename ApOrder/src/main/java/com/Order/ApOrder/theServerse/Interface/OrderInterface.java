package com.Order.ApOrder.theServerse.Interface;

import com.Order.ApOrder.theModel.Entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderInterface {

    Optional<Order> addOrder(Order order);

    Optional<Order> updateOrder(Order order, Long id);

    void deleteOrder(Long id);

    Optional<Order> getOrder(Long id);

    Optional<List<Order>>  getAllOrders();
}
