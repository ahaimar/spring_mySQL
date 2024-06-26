package com.Order.ApOrder.theController;


import com.Order.ApOrder.theModel.Entity.Supplier;
import com.Order.ApOrder.theServerse.Service.SerSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/supplier")
@CrossOrigin("http://localhost:5173")
public class ConSupplier {

    @Autowired
    private SerSupplier serSupplier;

    @GetMapping("/getSuppliers")
    public ResponseEntity<List<Supplier>> getAllSupplier(){

        return new ResponseEntity<List<Supplier>>(this.serSupplier.getAllSuppliers().get(), HttpStatus.OK);
    }

    @GetMapping("/getSupplierById/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id){

        return new ResponseEntity<Supplier>(this.serSupplier.getSupplierById(id).get(), HttpStatus.OK);
    }
    @PostMapping("/addSupplier")
    public void  addSupplier(@RequestBody Supplier supplier){

        this.serSupplier.addSupplier(supplier);
    }
    @PutMapping("/updateSupplier/{id}")
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier, @PathVariable String id){

        Long a = Long.parseLong(id);
        return new ResponseEntity<>(this.serSupplier.updateSupplier(supplier, a).get().get(), HttpStatus.OK);
    }
    @DeleteMapping("/deleteSupplier/{id}")
    public void deleteSupplier(@PathVariable Long id){

        this.serSupplier.deleteSupplier(id);
    }
}









