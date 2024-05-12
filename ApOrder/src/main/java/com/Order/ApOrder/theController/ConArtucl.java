package com.Order.ApOrder.theController;


import com.Order.ApOrder.theServerse.Service.SerArtucle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://localhost:5173/")
@RestController("/Artucl")
@RequestMapping
public class ConArtucl {

    @Autowired
    private SerArtucle serArtucle;

 

}
