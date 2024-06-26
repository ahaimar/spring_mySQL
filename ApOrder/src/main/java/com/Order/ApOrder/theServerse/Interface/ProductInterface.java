package com.Order.ApOrder.theServerse.Interface;

import com.Order.ApOrder.theModel.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductInterface {

    Optional<Product> addProduct(Product product);

    Optional<Product> getProduct(Long id);

    Optional<List<Product>> getAllProduct();

    Optional<Product> upDataProduct(Product product, Long id);

    Optional<Product> deleteProduct(Long id);
}
