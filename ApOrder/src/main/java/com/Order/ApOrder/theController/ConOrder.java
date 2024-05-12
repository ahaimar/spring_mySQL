package com.Order.ApOrder.theController;


import com.Order.ApOrder.theServerse.Service.SerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("http://localhost:5173/")
@RequestMapping("/order")
public class ConOrder {

    @Autowired
    private SerOrder serOrder;




}