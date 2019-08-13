package com.test.test.dao;

import com.test.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    Product findById(int id);
}
