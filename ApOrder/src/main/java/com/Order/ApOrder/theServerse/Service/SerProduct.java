package com.Order.ApOrder.theServerse.Service;

import com.Order.ApOrder.theModel.Entity.Product;
import com.Order.ApOrder.theModel.theRepository.RepArtucle;
import com.Order.ApOrder.theServerse.Interface.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerProduct implements ProductInterface {

    @Autowired
    private RepArtucle repArtucle;


    @Override
    public Optional<Product> addProduct(Product product) {

        return Optional.of(repArtucle.save(product));
    }

    @Override
    public Optional<Product> updateProduct(Product product, Long id) {

        return repArtucle.findById(id).map(product1 -> {
            product1.setTitleProduct(product.getTitleProduct());
            product1.setPrice(product.getPrice());
            product1.setDescription(product.getDescription());
            return repArtucle.save(product1);
        });
    }

    @Override
    public void deleteProduct(Long id) {

        this.repArtucle.deleteById(id);
    }

    @Override
    public Optional<List<Product>> getAllProduct() {

        return Optional.of(repArtucle.findAll());
    }

    @Override
    public Optional<Product> getProductById(Long id) {

        return repArtucle.findById(id);
    }
}
