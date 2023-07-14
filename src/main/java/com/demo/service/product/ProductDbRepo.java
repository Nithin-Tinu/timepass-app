package com.demo.service.product;

// import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.model.Product;
import java.lang.Integer;

public interface ProductDbRepo extends MongoRepository<Product, Integer> {
}
