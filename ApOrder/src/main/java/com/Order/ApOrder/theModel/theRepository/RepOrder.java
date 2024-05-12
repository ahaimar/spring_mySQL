package com.Order.ApOrder.theModel.theRepository;

import com.Order.ApOrder.theModel.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepOrder extends JpaRepository<Order, Long> {
}
