package com.test.test.dao;

import com.test.test.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop", 890, 690));
        products.add(new Product(2, "Roomba", 650, 450));
        products.add(new Product(3, "Table", 150, 1));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);

        return product;
    }
}
