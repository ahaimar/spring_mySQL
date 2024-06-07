package com.Order.ApOrder.theModel.theRepository;

import com.Order.ApOrder.theModel.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepSupplier extends JpaRepository<Supplier, String> {

    Optional<Supplier> findByCin(String cin);
    Optional<Supplier> deleteByCin(String cin);
}
