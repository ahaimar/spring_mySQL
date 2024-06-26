package com.Order.ApOrder.theServerse.Interface;

import com.Order.ApOrder.theModel.Entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierInterface {


    Optional<Supplier> getSupplierById(Long id);

    Optional<Supplier> addSupplier(Supplier supplier);

    Optional<List<Supplier>> getAllSuppliers();

    Optional<Optional<Supplier>> updateSupplier(Supplier supplier, Long id);

    Optional<Supplier> deleteSupplier(Long id);
}
