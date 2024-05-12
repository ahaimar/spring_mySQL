package com.Order.ApOrder.theModel.theRepository;

import com.Order.ApOrder.theModel.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepUser extends JpaRepository<User, String> {

    Optional<User> getEntUserByCin(String cin);

    Optional<User> findByCin(String cin);
}
