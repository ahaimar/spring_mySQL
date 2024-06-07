package com.Order.ApOrder.theController;


import com.Order.ApOrder.theModel.Entity.Supplier;
import com.Order.ApOrder.theServerse.Service.SerSopplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/sopplier")
public class ConSopplier {

    @Autowired
    private SerSopplier serSopplier;

    @GetMapping("/getSuppliers")
    public ResponseEntity<List<Supplier>> getAllSupplier(){

        return new ResponseEntity<List<Supplier>>(this.serSopplier.getAllSuppliers().get(), HttpStatus.OK);
    }

    @GetMapping("/getSupplierByCin")
    public ResponseEntity<Supplier> getSupplierByCin(@RequestParam String cin){

        return new ResponseEntity<Supplier>(this.serSopplier.getSupplierByCin(cin).get(), HttpStatus.OK);
    }
    @PostMapping("/addSupplier")
    public void addSupplier(@RequestBody Supplier supplier){

        this.serSopplier.addSupplier(supplier);
    }
    @PostMapping("/updateSupplier")
    public void updateSupplier(@RequestBody Supplier supplier){

        this.serSopplier.updateSupplier(supplier);
    }
    @DeleteMapping("/deleteSupplier")
    public void deleteSupplier(@RequestParam String cin){

        this.serSopplier.deleteSupplier(cin);
    }
}









