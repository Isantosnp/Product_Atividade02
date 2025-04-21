package com.example.demo.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.projeto.model.Product;
import com.example.demo.projeto.service.ProductService;

@Controller
@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus /* retorna que o produto foi adicionado com sucesso */
    public Product add(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}") // Mapeia requisições PUT com um id na URL, tipo: /produtos/1
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id, // Pega o id da URL
            @RequestBody Product updatedProduct // Pega o produto do corpo da requisição
    ) {
        // Chama o service para atualizar o produto e recebe um Optional<Product>
        Optional<Product> product = productService.updateProduct(id, updatedProduct);

        /* Se encontrou o produto, retorna 200 OK com ele
        /Se não encontrou, retorna 404 Not Found*/
        return product
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteProduct(@PathVariable Long id){
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build(): ResponseEntity.notFound().build();
    }

}
