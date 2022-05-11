package com.kafka.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.kafka.entity.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String>{

}
