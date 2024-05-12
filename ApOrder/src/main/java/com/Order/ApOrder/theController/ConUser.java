package com.Order.ApOrder.theController;

import com.Order.ApOrder.theModel.Entity.User;
import com.Order.ApOrder.theServerse.Service.SerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RequestMapping("/user")
@RestController
public class ConUser {

    @Autowired
    private SerUser serUser;

    @PostMapping("/login")
    public void login(@RequestParam String cin, @RequestParam String ferstName, @RequestParam String lastName, @RequestParam String address, @RequestParam String email, @RequestParam String phone) {

        User user = new User(cin, ferstName, lastName, address, email, phone);
        this.serUser.addUser(user);
    }

    @PostMapping("/getUserByCin")
    public ResponseEntity<User> getUserByCin(@RequestParam String cin)throws NoSuchElementException {

        return new ResponseEntity<User>(this.serUser.getUserByCin(cin).get(), HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers()throws NoSuchElementException {

        //return this.serUser.getAllUsers().get();
        return new ResponseEntity<List<User>>(this.serUser.getAllUsers().get(), HttpStatus.OK);
    }

    @PostMapping("/updateUser")
    public void updateUser(@RequestBody User user) {

        this.serUser.updateUser(user);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam String cin) {

        this.serUser.deleteUser(cin);
    }

    @GetMapping("/test")
    public String test() {

        return "test this code is done : ";
    }

}


