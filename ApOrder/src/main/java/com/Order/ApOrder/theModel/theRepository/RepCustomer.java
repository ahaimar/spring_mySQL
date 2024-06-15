package com.Order.ApOrder.theModel.theRepository;

import com.Order.ApOrder.theModel.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepCustomer extends JpaRepository<Customer, Long> {
}
