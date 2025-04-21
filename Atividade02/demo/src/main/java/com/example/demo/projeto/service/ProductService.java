package com.example.demo.projeto.service;

import com.example.demo.projeto.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextID = 1L;

    public List<Product> getAllProducts(){
        return products;
    }

    public Product addProduct( Product product){
        product.setId(nextID++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
    }

    public Optional<Product> updateProduct(Long id, Product updatedProduct) {

        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    public boolean deleteProduct(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    
}
