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
@CrossOrigin("http://localhost:5173")
public class ConUser {

    @Autowired
    private SerUser serUser;

    @PostMapping("/login")
    public void login(@RequestBody String cin, @RequestBody String ferstName, @RequestBody String password,@RequestBody String email, @RequestBody String phone) {

        this.serUser.login(cin, ferstName, password,email, phone);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {

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


