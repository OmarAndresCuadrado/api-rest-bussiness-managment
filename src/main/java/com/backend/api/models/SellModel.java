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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sells")
public class SellModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String dateBillsDay;

	private String dateBillsMonth;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	/*Relacion uno a mucho unidireccional importante el joinColumn*/
	@JsonIgnoreProperties(value = { "sells", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name="sell_id")
	private List<BillModel> bills;

	public SellModel() {
		this.bills = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateBillsDay() {
		return dateBillsDay;
	}

	public void setDateBillsDay(String dateBillsDay) {
		this.dateBillsDay = dateBillsDay;
	}

	public String getDateBillsMonth() {
		return dateBillsMonth;
	}

	public void setDateBillsMonth(String dateBillsMonth) {
		this.dateBillsMonth = dateBillsMonth;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
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
