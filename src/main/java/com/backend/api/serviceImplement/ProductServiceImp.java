package com.backend.api.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.api.models.ProductModel;
import com.backend.api.respository.ProductRepository;
import com.backend.api.serviceInterface.ProductServiceInterface;

@Service
public class ProductServiceImp implements ProductServiceInterface {

	@Autowired
	ProductRepository productDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductModel> listOfProducts() {
		return productDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductModel findProductById(Long id) {
		return productDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ProductModel saveProduct(ProductModel productEntity) {
		return productDao.save(productEntity);
	}

	@Override
	@Transactional
	public void deleteProduct(Long id) {
		productDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductModel> listOfProductsfindByName(String productName) {
		return productDao.findProductByName(productName);
	}
	
	

	
}
