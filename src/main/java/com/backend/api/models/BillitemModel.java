package com.backend.api.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bill_item")
public class BillitemModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer amount;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductModel product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public BigDecimal getImporte() {
		BigDecimal importeB = BigDecimal.valueOf(0.00);
		BigDecimal amountB = BigDecimal.valueOf(amount.doubleValue());
		BigDecimal priceB = BigDecimal.valueOf(product.getPrice());
		importeB = amountB.multiply(priceB);
		return importeB;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
