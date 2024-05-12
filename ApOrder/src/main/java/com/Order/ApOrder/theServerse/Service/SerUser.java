package com.Order.ApOrder.theServerse.Service;

import com.Order.ApOrder.theModel.Entity.User;
import com.Order.ApOrder.theModel.theRepository.RepUser;
import com.Order.ApOrder.theServerse.Interface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerUser implements UserInterface {

    @Autowired
    private RepUser repUser;

    /*++++++++++++++++++++++++++++|      the functions      |++++++++++++++++++++++++++++++++++++*/

    @Override
    public Optional<User> getUserByCin(String cin){
        Optional<User> user = this.repUser.getEntUserByCin(cin);
        return user.map(Optional::ofNullable).orElse(Optional.empty());
    }

    @Override
    public Optional<User> addUser(User user) {

        try {
            // Implement logic to add a user
            User addedUser = repUser.save(user);
            return Optional.ofNullable(addedUser);
        } catch (DataAccessException ex) {
            // Handle the DataAccessException  here, log it or perform any necessary actions
            ex.printStackTrace(); // Example: Print the stack trace
            return Optional.empty(); // Return an empty Optional in case of an DataAccessException 
        }
    }

    @Override
    public Optional<List<User>> getAllUsers() {

        try {
            List<User> users = this.repUser.findAll();
            return Optional.of(users);
        } catch (DataAccessException  ex) {
            // Handle the DataAccessException  here, log it or perform any necessary actions
            ex.printStackTrace(); // Example: Print the stack trace
            return Optional.empty(); // Return an empty Optional in case of an DataAccessException 
        }
    }

    @Override
    public Optional<User> updateUser(User user) {

        try {
            // Check if the user exists
            Optional<User> existingUserOptional = repUser.findByCin(user.getCin());
            if (existingUserOptional.isPresent()) {
                User existingUser = existingUserOptional.get();
                // Update the user properties
                // Update other properties as needed
                existingUser.setFerstName(user.getFerstName());
                existingUser.setLastName(user.getLastName());
                existingUser.setPassword(user.getPassword());
                existingUser.setAddress(user.getAddress());
                existingUser.setAge(user.getAge());
                existingUser.setEmail(user.getEmail());
                existingUser.setPhone(user.getPhone());

                // Save the updated user
                User updatedUser = repUser.save(existingUser);
                return Optional.of(updatedUser);
            } else {
                // User not found
                return Optional.empty();
            }
        } catch (DataAccessException  ex) {
            // Handle the DataAccessException  here, log it or perform any necessary actions
            ex.printStackTrace(); // Example: Print the stack trace
            return Optional.empty(); // Return an empty Optional in case of an DataAccessException 
        }
    }

    @Override
    public void deleteUser(String cin) {

        try {
            // Check if the user exists
            Optional<User> existingUserOptional = repUser.findByCin(cin);
            if (existingUserOptional.isPresent()) {
                User existingUser = existingUserOptional.get();
                // Delete the user
                repUser.delete(existingUser);
            } else {
                // User not found
            }
        } catch (DataAccessException  ex) {
            // Handle the DataAccessException  here, log it or perform any necessary actions
            ex.printStackTrace(); // Example: Print the stack trace
        }

    }
}
