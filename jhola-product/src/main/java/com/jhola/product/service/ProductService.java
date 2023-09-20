package com.jhola.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhola.product.dto.Categories;
import com.jhola.product.dto.ProductDTO;
import com.jhola.product.model.Product;
import com.jhola.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public boolean createProduct(ProductDTO productDTO) {
		Product productEntity = modelMapper.map(productDTO, Product.class);
		repository.save(productEntity);
		return true;
	}

	public List<ProductDTO> findByPrice(int price) {
		ArrayList<ProductDTO> productsByPrice = new ArrayList<>();
		Iterable<Product> findByPrice = repository.findByPrice(price);
		productsByPrice.forEach(product -> {
			productsByPrice.add(modelMapper.map(findByPrice, ProductDTO.class));
		});
		return productsByPrice;
	}

	public List<ProductDTO> findByCategory(String category) {
		List<Product> listOfProducts = repository.findByCategory(Categories.valueOf(category));
		List<ProductDTO> listOfProductDTO = new ArrayList<>();

		for (Product product : listOfProducts) {
			ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
			listOfProductDTO.add(productDTO);
		}
		return listOfProductDTO;
	}

	public ProductDTO getProduct(Long productId) {
		Optional<Product> productDetail = repository.findById(productId);
		if (productDetail.isPresent()) {
			Product productEntity = productDetail.get();
			ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
			return productDTO;
		}
		return null;
	}

	public ProductDTO updateProduct(Long productID, ProductDTO productDTO) {
		Optional<Product> productDetail = repository.findById(productID);
		if (productDetail.isPresent()) {
			Product productEntity = productDetail.get();

			productEntity.setPrice(productDTO.getPrice());

			Product updatedProduct = repository.save(productEntity);
			ProductDTO updatedProductDTO = modelMapper.map(updatedProduct, ProductDTO.class);
			return updatedProductDTO;
		}
		return null;
	}

	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> listOfProducts = new ArrayList<>();
		Iterable<Product> products = repository.findAll();
		products.forEach(product -> {
			listOfProducts.add(modelMapper.map(product, ProductDTO.class));
		});
		return listOfProducts;
	}

	public boolean deleteProduct(Long productId) {
		repository.deleteById(productId);
		return true;
	}
}
