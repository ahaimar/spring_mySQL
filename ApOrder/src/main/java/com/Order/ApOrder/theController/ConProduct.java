package com.Order.ApOrder.theController;


import com.Order.ApOrder.theModel.Entity.Product;
import com.Order.ApOrder.theServerse.Service.SerProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController("/Artucl")
@RequestMapping
public class ConProduct {

    @Autowired
    private SerProduct serproduct;
    
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProduct(){

        return new ResponseEntity<List<Product>>(serproduct.getAllProduct().get(), HttpStatus.OK); 
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        
        return new ResponseEntity<Product>(serproduct.getProductById(id).get(), HttpStatus.OK); 
    }
    
    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        
        return new ResponseEntity<Product>(serproduct.addProduct(product).orElseThrow(() -> new RuntimeException("Product not found")), HttpStatus.OK); 
    }
    
    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
        
        return new ResponseEntity<Product>(serproduct.updateProduct(product, id).orElseThrow(() -> new RuntimeException("Product not found")), HttpStatus.OK); 
    }
    
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){
        
        serproduct.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK); 
    }
    
}
