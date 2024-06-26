package com.Order.ApOrder.theServerse.Service;

import com.Order.ApOrder.theModel.Entity.Product;
import com.Order.ApOrder.theModel.theRepository.RepProduct;
import com.Order.ApOrder.theServerse.Interface.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerProduct implements ProductInterface {

    @Autowired
    private RepProduct repProduct;

    @Override
    public Optional<Product> addProduct(Product product) {

        return  Optional.of(repProduct.save(product));
    }

    @Override
    public Optional<Product> getProduct(Long id) {

        return Optional.of(this.repProduct.findById(id).get());
    }

    @Override
    public Optional<List<Product>> getAllProduct() {

        return Optional.of(this.repProduct.findAll());
    }

    @Override
    public Optional<Product> upDataProduct(Product product, Long id) {


        return this.repProduct.findById(id).map(product1 -> {
            product1.setProductName(product.getProductName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            return repProduct.save(product1);
        });
    }

    @Override
    public Optional<Product> deleteProduct(Long id) {

        return repProduct.findById(id).map(user -> {
            repProduct.deleteById(id);
            return user;
        });
    }
}
