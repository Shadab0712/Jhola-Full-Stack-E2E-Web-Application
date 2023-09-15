package com.jhola.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhola.product.model.Product;

public interface ProductRepository extends CrudRepository<Product , Long> {

}
