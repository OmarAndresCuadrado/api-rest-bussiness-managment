package com.backend.api.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.api.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
	
	@Query(value = "select * from products where name like ?1%", nativeQuery = true)
	public List<ProductModel> findProductByName(String productName);

}
