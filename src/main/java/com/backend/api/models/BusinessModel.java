package com.backend.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "business")
public class BusinessModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El nombre no puede estar vacio")
	@Size(min = 4, max = 32, message = "El nombre debe tener entre 4 y 32 caracteres")
	@Column(length = 32, nullable = false)
	private String name;

	@NotEmpty(message = "La direccion no puede estar vacio")
	@Size(min = 4, max = 32, message = "La direccion debe tener entre 4 y 32 caracteres")
	@Column(length = 32, nullable = false)
	private String address;

	@NotEmpty(message = "El telefono no puede estar vacio")
	@Size(min = 4, max = 16, message = "El numero de telefono debe tener entre 4 y 16 caracteres")
	@Column(length = 16, nullable = false)
	private String phone;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	/*Relacion uno a mucho unidireccional importante el joinColumn*/
	@JsonIgnoreProperties(value = { "business", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name="business_id")
	private List<ProductModel> products;

	/*Relacion uno a mucho unidireccional importante el joinColumn*/
	@JsonIgnoreProperties(value = { "business", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name="business_id")
	private List<ClientModel> clients;

	public BusinessModel() {
		this.products = new ArrayList<>();
		this.clients = new ArrayList<>();
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	public List<ClientModel> getClients() {
		return clients;
	}

	public void setClients(List<ClientModel> clients) {
		this.clients = clients;
	}
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
