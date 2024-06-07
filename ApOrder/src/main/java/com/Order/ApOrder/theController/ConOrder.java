package com.Order.ApOrder.theController;


import com.Order.ApOrder.theModel.Entity.Order;
import com.Order.ApOrder.theServerse.Service.SerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:5173/")
@RequestMapping("/order")
public class ConOrder {

    @Autowired
    private SerOrder serOrder;


    @PostMapping
    public void addOrder(@RequestBody Order order) {

        serOrder.addOrder(order);
    }
    @GetMapping("/getAllOrder")
    public ResponseEntity<List<Order>> getAllOrder() {

        return new ResponseEntity<List<Order>>(serOrder.getAllOrders().get(), HttpStatus.OK);
    }

    @GetMapping("/getOrderById")
    public ResponseEntity<Order> getOrderById(@RequestParam Long id) {

        return new ResponseEntity<Order>(serOrder.getOrder(id).get(), HttpStatus.OK);
    }
    @PostMapping("/updateOrder")
    public void updateOrder(@RequestBody Order order) {
        serOrder.updateOrder(order);
    }
    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestParam Long id) {
        serOrder.deleteOrder(id);
    }

}