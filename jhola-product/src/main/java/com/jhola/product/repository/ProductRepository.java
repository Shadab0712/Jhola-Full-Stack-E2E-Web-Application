package com.jhola.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jhola.product.dto.Categories;
import com.jhola.product.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByCategory(Categories category);

	List<Product> findByPrice(int price);

}
