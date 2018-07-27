package com.product.product.controller;

import com.product.product.model.Product;
import com.product.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {


    private ProductRepository productRepository;
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @PostMapping("")
    public Product createProduct(@Valid @RequestBody Product product) {

        return productRepository.save(product);
    }

    @RequestMapping("/all")
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Product> findById(@PathVariable("id") long id) {

        return productRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        productRepository.deleteById(id);

    }

    @PutMapping("/{id}")
    public Product editById(@PathVariable("id") long id, @RequestBody Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            return null;
        }
        product.setProductId(id);
        return productRepository.save(product);

    }
}