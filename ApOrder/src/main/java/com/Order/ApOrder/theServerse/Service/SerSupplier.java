package com.Order.ApOrder.theServerse.Service;

import com.Order.ApOrder.theModel.Entity.Supplier;
import com.Order.ApOrder.theModel.theRepository.RepSupplier;
import com.Order.ApOrder.theServerse.Interface.SupplierInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SerSupplier implements SupplierInterface {

    @Autowired
    private RepSupplier repSupplier;


    @Override
    public Optional<Supplier> getSupplierById(Long id) {
        return Optional.of(this.repSupplier.findById(id).get());
    }

    @Override
    public Optional<Supplier> addSupplier(Supplier supplier) {

        return Optional.of(this.repSupplier.save(supplier));
    }

    @Override
    public Optional<List<Supplier>> getAllSuppliers() {
        return Optional.of(this.repSupplier.findAll());
    }

    @Override
    public Optional<Optional<Supplier>> updateSupplier(Supplier supplier, Long id) {

        return repSupplier.findById(id).map(supplier1 -> {
            supplier1.setSupplierName(supplier.getSupplierName());
            supplier1.setSupplierPhone(supplier.getSupplierPhone());
            supplier1.setSupplierEmail(supplier.getSupplierEmail());
            return Optional.of(repSupplier.save(supplier1));
        });
    }

    @Override
    public Optional<Supplier> deleteSupplier(Long id) {

        return repSupplier.findById(id).map(supplier -> {
            repSupplier.deleteById(id);
            return supplier;
        });
    }
}
