package com.Order.ApOrder.theServerse.Interface;

import com.Order.ApOrder.theModel.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductInterface {

    Optional<Product> addProduct(Product product);

    Optional<Product> updateProduct(Product product, Long id);

    void deleteProduct(Long id);

    Optional<List<Product>> getAllProduct();

    Optional<Product> getProductById(Long id);
}
