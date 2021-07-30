package com.backend.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.api.models.ProductModel;
import com.backend.api.serviceInterface.ProductServiceInterface;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductServiceInterface productService;
	
	@GetMapping("/product")
	public List<ProductModel> listOfProducts() {
		return productService.listOfProducts();
	}
	
	@GetMapping("/product/{id}")
	public ProductModel findProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}
	
	@PostMapping("/product")
	public ProductModel saveProduct(@RequestBody ProductModel productEntity) {
		return productService.saveProduct(productEntity);
	}
	
	@PutMapping("/product/{id}")
	public ProductModel updateProduct(@RequestBody ProductModel productEntity, @PathVariable Long id ) {
		ProductModel productDatabase = null;
		productDatabase = productService.findProductById(id);
		productDatabase.setAmount(productEntity.getAmount());
		productDatabase.setDescription(productEntity.getDescription());
		productDatabase.setName(productEntity.getName());
		productDatabase.setPrice(productEntity.getPrice());
		return productService.saveProduct(productDatabase);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
	
	@GetMapping("/product/filter-products/{productName}")
	public List<ProductModel> listOfProductsByName(@PathVariable String productName){
		return this.productService.listOfProductsfindByName(productName);
	}

}
