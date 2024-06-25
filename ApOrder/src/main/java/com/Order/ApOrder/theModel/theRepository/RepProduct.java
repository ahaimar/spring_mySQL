package com.Order.ApOrder.theModel.theRepository;

import com.Order.ApOrder.theModel.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepProduct extends JpaRepository<Product, Long> {
}
