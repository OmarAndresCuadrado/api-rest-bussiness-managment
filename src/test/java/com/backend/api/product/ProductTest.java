package com.backend.api.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.backend.api.models.ProductModel;
import com.backend.api.respository.ProductRepository;

@DataJpaTest
class ProductTest {

	@Autowired
	ProductRepository productRepository;

	@Test
	void get_two_products_by_autoComplete() {
		List<ProductModel> products = productRepository.findProductByName("producto");
		assertNotNull(products.get(0));
		assertNotNull(products.get(1));
		assertEquals("producto 1", products.get(0).getName());
		assertEquals("producto 2", products.get(1).getName());
	}

	@Test
	void save_a_product() {
		ProductModel product = new ProductModel();
		ProductModel productCreated = new ProductModel();
		product.setName("product 3");
		product.setPrice(50000L);
		product.setDescription("new product 3");
		product.setAmount(10.0);
		productCreated = productRepository.save(product);
		assertNotNull(productCreated);
		assertEquals(50000L, productCreated.getPrice());
		assertEquals("product 3", productCreated.getName());
		assertEquals("new product 3", productCreated.getDescription());
		assertEquals(10.0, productCreated.getAmount());
		assertTrue(productCreated.getId() > 0);

	}

}
