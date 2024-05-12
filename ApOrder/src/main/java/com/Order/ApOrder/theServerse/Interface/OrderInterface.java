package com.Order.ApOrder.theServerse.Interface;

import com.Order.ApOrder.theModel.Entity.Artucle;
import com.Order.ApOrder.theModel.Entity.Order;
import com.Order.ApOrder.theModel.Entity.Supplier;
import com.Order.ApOrder.theModel.Entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderInterface {

    Optional<Order> addOrder(User client, Supplier supplier, Artucle artucle);

    Optional<Order> updateOrder(User client, Supplier supplier, Artucle artucle);

    void deleteOrder(Order order);

    Optional<Order> getOrder(Long id);

    Optional<List<Order>>  getAllOrders();
}
