package com.Order.ApOrder.theModel.theRepository;

import com.Order.ApOrder.theModel.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepCustomer extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
