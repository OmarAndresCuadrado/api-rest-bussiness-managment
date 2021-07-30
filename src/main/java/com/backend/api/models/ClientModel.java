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
@Table(name = "clients")
public class ClientModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "el nombre no puede estar vacio")
	@Size(min = 4, max = 16, message = "el nombre debe tener entre 4 y 16 caracteres")
	@Column(nullable = false, length = 16)
	private String name;

	@NotEmpty(message = "el apellido no puede estar vacio")
	@Size(min = 4, max = 16, message = "el apellido debe tener entre 4 y 16 caracteres")
	@Column(nullable = false, length = 16)
	private String lastName;

	private String address;

	@NotEmpty(message = "el telefono no puede estar vacio")
	@Size(min = 4, max = 16, message = "el telefono debe tener entre 4 y 16 caracteres")
	@Column(nullable = false, length = 16)
	private String phone;

	private String email;

	private Double points;

	private String privilages;

	@JsonIgnoreProperties(value = { "client", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
	private List<BillModel> bills;

	

	@NotNull(message = "no puede estar vacio")
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	public ClientModel() {
		this.bills = new ArrayList<>();
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public String getPrivilages() {
		return privilages;
	}

	public void setPrivilages(String privilages) {
		this.privilages = privilages;
	}

	public List<BillModel> getBills() {
		return bills;
	}

	public void setBills(List<BillModel> bills) {
		this.bills = bills;
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
