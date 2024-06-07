package com.Order.ApOrder.theServerse.Service;


import com.Order.ApOrder.theServerse.Interface.OrderInterface;
import com.Order.ApOrder.theModel.Entity.Artucle;
import com.Order.ApOrder.theModel.Entity.Order;
import com.Order.ApOrder.theModel.Entity.Supplier;
import com.Order.ApOrder.theModel.Entity.User;
import com.Order.ApOrder.theModel.theRepository.RepOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerOrder implements OrderInterface {

    @Autowired
    private RepOrder repOrder;

    @Override
    public Optional<Order> addOrder(Order order) {

        return Optional.of(repOrder.save(order));
    }

    @Override
    public Optional<Order> updateOrder(Order order) {

        return Optional.of(repOrder.save(order));
    }

    @Override
    public void deleteOrder(Long id) {

        this.repOrder.deleteById(id);
    }

    @Override
    public Optional<Order> getOrder(Long id) {

        Optional<Order> order = this.repOrder.findById(id);
        return order.map(Optional::ofNullable).orElse(Optional.empty());
    }

    @Override
    public Optional<List<Order>> getAllOrders() {

        return Optional.of(repOrder.findAll());
    }
}
