package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProduct();
    void deleteProduct(Long id);
    Product updateProduct(Long id, Product product);
    Product replaceProduct(Long id, Product product);
}
