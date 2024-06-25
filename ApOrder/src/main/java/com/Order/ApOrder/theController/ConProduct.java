package com.Order.ApOrder.theController;

import com.Order.ApOrder.theModel.Entity.Product;
import com.Order.ApOrder.theServerse.Service.SerProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:5173")
public class ConProduct {

    @Autowired
    private SerProduct serProduct;

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){

        return new ResponseEntity<>(this.serProduct.getProduct(id).get(), HttpStatus.OK);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<Product> allProduct(){

        return new ResponseEntity<>(this.serProduct.getAllProduct().get(), HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){

        this.serProduct.addProduct(product);
    }

    @PutMapping("/upDataProduct/{id}")
    public ResponseEntity<Product> upData(@RequestBody Product product, @PathVariable String id){

        try {
            Long userId = Long.parseLong(id);
            return new ResponseEntity<>(this.serProduct.upDataProduct(product, userId).get(), HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {

        this.serProduct.deleteProduct(id);
    }
}
