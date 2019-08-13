package com.test.test.controller;

import com.test.test.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping(value = "product/{id}")
    public Product showProduct(@PathVariable int id) {
        Product product = new Product(id, "mon produit", 100);

        return product;
    }
}
