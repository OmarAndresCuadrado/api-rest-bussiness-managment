package com.backend.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class ProductModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "el nombre del producto no puede estar vacio")
	@Size(min = 4, max = 64, message = "el nombre debe tener entre 4 y 64 caracteres")
	@Column(nullable = false, length = 64)
	private String name;

	@Column(nullable = false)
	private Long price;

	@Column(nullable = false)
	private Double amount;

	@NotEmpty(message = "la descripcion no puede estar vacia")
	@Size(min = 4, max = 64, message = "la descripcion debe tener entre 4 y 64 caracteres")
	@Column(nullable = false, length = 64)
	private String description;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
