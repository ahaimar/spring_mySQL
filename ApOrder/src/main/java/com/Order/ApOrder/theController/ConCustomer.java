package com.Order.ApOrder.theController;

import com.Order.ApOrder.theModel.Entity.Customer;
import com.Order.ApOrder.theServerse.Service.SerCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RequestMapping("/customer")
@RestController
@CrossOrigin("http://localhost:5173")
public class ConCustomer {

    @Autowired
    private SerCustomer serCustomer;

    @GetMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody Customer cus) {
        Optional<Customer> customer = serCustomer.login(cus.getEmail(), cus.getPassword());

        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/addCustomer")
    public void addUser(@RequestBody Customer user) {

        this.serCustomer.addUser(user);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Customer> search(@PathVariable String id) {
        Long a = Long.parseLong(id);
        return this.serCustomer.getUserById(a)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllUsers()throws NoSuchElementException {

        return new ResponseEntity<>(this.serCustomer.getAllUsers().get(), HttpStatus.OK);
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateUser(@RequestBody Customer user, @PathVariable String id) {
        try {
            Long userId = Long.parseLong(id);
            return new ResponseEntity<>(this.serCustomer.updateUser(user, userId).get(), HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteUser(@PathVariable Long id) {

        this.serCustomer.deleteCustomer(id);
    }
}

