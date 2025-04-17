package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    private Product getProductById(@PathVariable("id") Long id){
       return productService.getSingleProduct(id);
    }

    @GetMapping()
    private List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    private void deleteProduct(Long id){

    }

    @PatchMapping("/{id}")
    private Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
     return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    private Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
      return null;
    }
}
