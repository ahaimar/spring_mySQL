package com.Order.ApOrder.theServerse.Interface;

import com.Order.ApOrder.theModel.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {


    Optional<User> login(String cin, String FerstName, String password, String email, String phone);
    Optional<User> getUserByCin(String cin);

    Optional<User> addUser(User user);

    Optional<List<User>> getAllUsers();

    Optional<User> updateUser(User user);

    void deleteUser(String EntUserId);
}
