package com.Order.ApOrder.theController;


import com.Order.ApOrder.theModel.Entity.Order;
import com.Order.ApOrder.theServerse.Service.SerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/order")
public class ConOrder {

    @Autowired
    private SerOrder serOrder;


    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order order) {

        this.serOrder.addOrder(order);
    }

    @PutMapping("/addAllOrders")
    public void addAll(@RequestBody List<Order> orders){

        this.serOrder.addAllOrder(orders);
    }

    @GetMapping("/getAllOrder")
    public ResponseEntity<List<Order>> getAllOrder() {

        return new ResponseEntity<List<Order>>(serOrder.getAllOrders().get(), HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {

        return new ResponseEntity<Order>(serOrder.getOrder(id).get(), HttpStatus.OK);
    }

    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable String id) {

        try {
            Long orderId = Long.parseLong(id);
            return new ResponseEntity<>(this.serOrder.updateOrder(order, orderId).get(), HttpStatus.OK);
        }catch (NumberFormatException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable Long id) {
        this.serOrder.deleteOrder(id);
    }
}