package com.Order.ApOrder.theServerse.Interface;

import com.Order.ApOrder.theModel.Entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierInterface {


    Optional<Supplier> getSupplierByCin(String cin);

    Optional<Supplier> addSupplier(Supplier supplier);

    Optional<List<Supplier>> getAllSuppliers();

    Optional<Supplier> updateSupplier(Supplier supplier);

    void deleteSupplier(String EntSupplierId);
}
