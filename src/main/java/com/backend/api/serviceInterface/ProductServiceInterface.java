package com.backend.api.serviceInterface;

import java.util.List;

import com.backend.api.models.ProductModel;

public interface ProductServiceInterface {

	public List<ProductModel> listOfProducts();

	public ProductModel findProductById(Long id);

	public ProductModel saveProduct(ProductModel productEntity);

	public void deleteProduct(Long id);
	
	public List<ProductModel> listOfProductsfindByName(String productName);
}
