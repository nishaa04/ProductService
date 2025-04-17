package com.example.productservice.controllers;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
    //    throw new RuntimeException("Something went wrong");
//        ResponseEntity<Product> responseEntity = null;
//        try {
//            Product product = productService.getSingleProduct(id);
//            responseEntity = new ResponseEntity<>(
//                    product,
//                    HttpStatus.FORBIDDEN
//            );
//        } catch (RuntimeException e) {
//              responseEntity = new ResponseEntity<>(
//                      HttpStatus.NOT_FOUND
//              );
//        }
        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
        return response;
    }

    @GetMapping()
    private List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/{id}")
    private void deleteProduct(@PathVariable("id") Long id) {
            productService.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    private Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
     return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    private Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
      return productService.replaceProduct(id, product);
    }

//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<String> handleArithmeticException(){
//      ResponseEntity<String> response = new ResponseEntity<>(
//           "ArrayIndexOutOfBounds Exception has happened, Inside the controller", HttpStatus.BAD_REQUEST
//      );
//      return response;
//    }
}
