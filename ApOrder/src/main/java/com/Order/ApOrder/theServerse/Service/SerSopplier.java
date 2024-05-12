package com.Order.ApOrder.theServerse.Service;

import com.Order.ApOrder.theModel.Entity.Supplier;
import com.Order.ApOrder.theModel.theRepository.RepSupplier;
import com.Order.ApOrder.theServerse.Interface.SupplierInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SerSopplier implements SupplierInterface {

    @Autowired
    private RepSupplier repSupplier;


    @Override
    public Optional<Supplier> getSupplierByCin(String cin) {
        Optional<Supplier> supplier = repSupplier.findByCin(cin);
        return supplier.map(Optional::ofNullable).orElse(Optional.empty());
    }

    @Override
    public Optional<Supplier> addSupplier(Supplier supplier) {
        try{

            Supplier supplier1 = repSupplier.save(supplier);
            return Optional.ofNullable(supplier1);

        }catch(DataAccessException  ex){

            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Supplier>> getAllSuppliers() {
        try{
            List<Supplier> supplier = this.repSupplier.findAll();
            return Optional.of(supplier);

        }catch (DataAccessException ex){

            return Optional.empty();

        }
    }

    @Override
    public Optional<Supplier> updateSupplier(Supplier supplier) {
        try{

            Optional<Supplier> exiSup= repSupplier.findByCin(supplier.getCin());
            if(exiSup.isPresent()){
                Supplier sup = exiSup.get();
                sup.setCin(supplier.getCin());
                sup.setFerstName(supplier.getFerstName());
                sup.setLastName(supplier.getLastName());
                sup.setPhone(supplier.getPhone());
                sup.setEmail(supplier.getEmail());
                sup.setNomberSupplier(supplier.getNomberSupplier());

                //
                Supplier updatedSupplier = repSupplier.save(sup);
                return Optional.of(updatedSupplier);

            }else{

                return Optional.empty();
            }

        }catch (DataAccessException  ex){

            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteSupplier(String cin) {

        this.repSupplier.deleteById(cin);
    }
}
