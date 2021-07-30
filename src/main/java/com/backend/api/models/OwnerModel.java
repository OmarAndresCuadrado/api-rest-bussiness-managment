package com.backend.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "owners")
public class OwnerModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "el nombre no puede estar vacio")
	@Size(min = 4, max = 16, message = "el nombre debe tener entre 4 y 16 caracteres")
	@Column(nullable = false, length = 16)
	private String name;

	@NotEmpty(message = "el apellido no puede estar vacio")
	@Size(min = 4, max = 16, message = "el nombre debe tener entre 4 y 16 caracteres")
	@Column(nullable = false, length = 16)
	private String lastName;

	@NotEmpty(message = "la direccion no puede estar vacia")
	@Size(min = 4, max = 50, message = "la direccion debe tener entre 4 y 50 caracteres")
	@Column(nullable = false, length = 50)
	private String address;

	@NotEmpty(message = "el telefono no puede estar vacio")
	@Size(min = 4, max = 16, message = "el telefono debe tener entre 4 y 16 caracteres")
	@Column(nullable = false, length = 16)
	private String phone;

	@NotEmpty(message = "el correo no puede estar vacio")
	@Size(min = 4, max = 32, message = "el correo debe tener entre 4 y 32 caracteres")
	@Email(message = "la direccion de correo electronico no es valida")
	@Column(nullable = false, length = 32)
	private String email;

	@NotEmpty(message = "el nombre de usuario no puede estar vacio")
	@Size(min = 4, max = 32, message = "el nombre de usuario debe tener entre 4 y 32 caracteres")
	@Column(nullable = false, unique = true, length = 32)
	private String username;

	@NotEmpty(message = "la contrasena no puede estar vacia")
	@Size(min = 4, max = 32, message = "la contrasena debe tener entre 4 y 32 caracteres")
	@Column(nullable = false, length = 32)
	private String password;

	private Boolean enabled;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "business_id", referencedColumnName = "id")
	@JsonIgnoreProperties(value = { "owners", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	private BusinessModel business;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public BusinessModel getBusiness() {
		return business;
	}

	public void setBusiness(BusinessModel business) {
		this.business = business;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
