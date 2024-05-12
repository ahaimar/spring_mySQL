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
    public Optional<Order> addOrder(User usre, Supplier supplier, Artucle artucle) {

        Order order = new Order(usre, supplier, artucle);
        try {
            Order addedOrder = repOrder.save(order);
            return Optional.of(addedOrder);
        } catch (DataAccessException  ex) {
            // Log the DataAccessException  or perform any necessary actions
            // logger.error("Failed to add order: " + ex.getMessage(), ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Order> updateOrder(User client, Supplier supplier, Artucle artucle) {

        try{
            Order order = new Order(client, supplier, artucle);
            Optional<Order> existingOrderOptional = repOrder.findById(order.getId());
            if(existingOrderOptional.isPresent()){

                Order existingOrder = existingOrderOptional.get();
                existingOrder.setClient(order.getClient());
                existingOrder.setSupplier(order.getSupplier());
                Order updatedOrder = repOrder.save(existingOrder);
                return Optional.of(updatedOrder);
            }else {

                return Optional.empty();
            }
        }catch (DataAccessException ex){

            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteOrder(Order order) {
        this.repOrder.delete(order);
    }

    @Override
    public Optional<Order> getOrder(Long id) {

        Optional<Order> order = this.repOrder.findById(id);
        return order.map(Optional::ofNullable).orElse(Optional.empty());
    }

    @Override
    public Optional<List<Order>> getAllOrders() {

        try{

            List<Order> orders = this.repOrder.findAll();
            return Optional.of(orders);
        }catch (DataAccessException  ex) {
            // Handle the DataAccessException  here, log it or perform any necessary actions
            ex.printStackTrace();
            return Optional.empty();
        }
    }
}
