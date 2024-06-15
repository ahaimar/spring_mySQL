package com.Order.ApOrder.theController;

import com.Order.ApOrder.theModel.Entity.Customer;
import com.Order.ApOrder.theServerse.Service.SerCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RequestMapping("/customer")
@RestController
@CrossOrigin("http://localhost:5173")
public class ConCustomer {

    @Autowired
    private SerCustomer serCustomer;

    @PostMapping("/login")
    public void login(@RequestBody Long id, @RequestBody String firstName, @RequestBody String password, @RequestBody String email) {

        this.serCustomer.login(id, firstName, password,email);
    }

    @PostMapping("/addCustomer")
    public void addUser(@RequestBody Customer user) {

        this.serCustomer.addUser(user);
    }
    @PostMapping("/getCustomerById")
    public ResponseEntity<Customer> getUserByCin(@RequestParam Long id){

        return new ResponseEntity<Customer>(this.serCustomer.getUserById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllUsers()throws NoSuchElementException {

        //return this.serCustomer.getAllUsers().get();
        return new ResponseEntity<List<Customer>>(this.serCustomer.getAllUsers().get(), HttpStatus.OK);
    }

    @PostMapping("/updateCustomer")
    public void updateUser(@RequestBody Customer user, @RequestParam Long id) {

        this.serCustomer.updateUser(user, id);
    }

    @DeleteMapping("/deleteCustomer")
    public void deleteUser(@RequestParam Long id) {

        this.serCustomer.deleteUser(String.valueOf(id));
    }
}


