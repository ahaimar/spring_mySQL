package com.Order.ApOrder.theServerse.Service;

import com.Order.ApOrder.theModel.Entity.Product;
import com.Order.ApOrder.theModel.theRepository.RepProduct;
import com.Order.ApOrder.theServerse.Interface.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SerProduct implements ProductInterface {

    @Autowired
    private RepProduct repProduct;

    @Override
    public Optional<Product> addProduct(Product product) {

        return Optional.of(this.repProduct.save(product));
    }

    @Override
    public Optional<Product> getProduct(Long id) {

        return Optional.of(this.repProduct.findById(id).get());
    }

    @Override
    public Optional<Product> getAllProduct() {

        return Optional.of((Product) this.repProduct.findAll());
    }

    @Override
    public Optional<Product> upDataProduct(Product product, Long id) {
        return repProduct.findById(id).map(product1 -> {

            product.setProductName(product.getProductName());
            product.setDestination(product.getDestination());
            product.setPrice(product.getPrice());
            return repProduct.save(product);
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
