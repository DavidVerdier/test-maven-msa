package com.test.test.controller;

import com.test.test.dao.ProductDao;
import com.test.test.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "products")
    public List<Product> listProducts() {
        return productDao.findAll();
    }

    @GetMapping(value = "product/{id}")
    public Product showProduct(@PathVariable int id) {
        return productDao.findById(id);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
        Product product1 = productDao.save(product);

        if (null == product) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id]")
                .buildAndExpand(product1.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "products/{prixLimit}")
    public List<Product> showProductByPrice(@PathVariable int prixLimit) {
        return productDao.chercherUnProduitCher(prixLimit);//  .findByPrixGreaterThan(prixLimit);
    }
}
