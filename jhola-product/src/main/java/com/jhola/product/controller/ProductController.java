package com.jhola.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jhola.product.dto.ProductDTO;
import com.jhola.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/api/v1/product/")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
		service.createProduct(productDTO);
		return new ResponseEntity<>("New Product Created", HttpStatus.CREATED);
	}

	@GetMapping("/api/v1/product/{productId}/")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Long productId) {
		ProductDTO product = service.getProduct(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PutMapping("/api/v1/product/{productId}/")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
		ProductDTO updateProduct = service.updateProduct(productId, productDTO);
		return new ResponseEntity<>(updateProduct, HttpStatus.CREATED);
	}

	@GetMapping("/api/v1/product/")
	public ResponseEntity<List<ProductDTO>> getAllPoducts() {
		List<ProductDTO> allProducts = service.getAllProducts();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

	@DeleteMapping("/api/v1/product/{productId}/")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
		service.deleteProduct(productId);
		return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
	}
}