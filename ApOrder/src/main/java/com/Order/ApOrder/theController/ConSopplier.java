package com.Order.ApOrder.theController;


import com.Order.ApOrder.theServerse.Service.SerSopplier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/sopplier")
public class ConSopplier {

    private final SerSopplier serSopplier;

    public ConSopplier(SerSopplier serSopplier) {
        this.serSopplier = serSopplier;
    }

 

}









