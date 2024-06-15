package com.Order.ApOrder.theModel.theRepository;

import com.Order.ApOrder.theModel.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepArtucle extends JpaRepository<Product, Long> {
}
