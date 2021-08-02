package com.backend.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> listOfProducts() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		Map<String, Object> response = new HashMap<>();

		try {
			products = productService.listOfProducts();

		} catch (DataAccessException e) {
			response.put("message", "Error getting list of products");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("message", "Transacction succesfully");
		response.put("products", products);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@GetMapping("/product/test")
	public String watch() {
		String newDevelopment = "test unoo";
		return newDevelopment;

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
	public ProductModel updateProduct(@RequestBody ProductModel productEntity, @PathVariable Long id) {
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
	public List<ProductModel> listOfProductsByName(@PathVariable String productName) {
		return this.productService.listOfProductsfindByName(productName);
	}

}
