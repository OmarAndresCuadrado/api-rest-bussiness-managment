package com.backend.api.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.ManyToOne;
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
@Table(name = "bills")
public class BillModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "la descripcion no puede estar vacia")
	@Size(min = 4, max = 64, message = "la descripcion debe tener entre 4 y 64 caracteres")
	@Column(nullable = false, length = 64)
	private String description;

	private String observation;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@JsonIgnoreProperties(value = { "bills", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private ClientModel client;


	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "bill_id")
	private List<BillitemModel> items;

	public BillModel() {
		this.items = new ArrayList<>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.valueOf(0.00);
		for (BillitemModel item : items) {
			total = total.add(item.getImporte());
		}
		return total;
	}

	public List<BillitemModel> getItems() {
		return items;
	}

	public void setItems(List<BillitemModel> items) {
		this.items = items;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
