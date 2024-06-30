package com.Order.ApOrder.theServerse.Service;


import com.Order.ApOrder.theServerse.Interface.OrderInterface;
import com.Order.ApOrder.theModel.Entity.Order;
import com.Order.ApOrder.theModel.theRepository.RepOrder;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Order> addAllOrder(List<Order> orders) {

        List<Order> savedOrders = repOrder.saveAll(orders);
        return Optional.of((Order) savedOrders);
    }

    @Override
    public Optional<Order> updateOrder(Order order, Long id) {

        return repOrder.findById(id).map(order1 -> {

            order1.setCustomer(order.getCustomer());
            order1.setProduct(order.getProduct());
            order1.setSupplier(order.getSupplier());
            order1.setQuantity(order.getQuantity());
            return repOrder.save(order1);
        });
    }

    @Override
    public void deleteOrder(Long id) {

        this.repOrder.deleteById(id);
    }

    @Override
    public Optional<Order> getOrder(Long id) {

        return  Optional.of(this.repOrder.findById(id).get());
    }

    @Override
    public Optional<List<Order>> getAllOrders() {

        return Optional.of(repOrder.findAll());
    }
}
