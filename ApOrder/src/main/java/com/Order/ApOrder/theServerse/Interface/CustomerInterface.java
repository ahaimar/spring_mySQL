package com.Order.ApOrder.theServerse.Interface;

import com.Order.ApOrder.theModel.Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerInterface {


    Optional<Customer> login(Long id, String FerstName, String password, String email);
    Optional<Customer> getUserById(Long id);

    Optional<Customer> addUser(Customer user);

    Optional<List<Customer>> getAllUsers();

    Optional<Customer> updateUser(Customer customer, Long id);

    void deleteUser(String EntUserId);
}
