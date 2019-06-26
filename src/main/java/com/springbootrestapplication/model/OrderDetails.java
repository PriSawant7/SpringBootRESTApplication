package com.springbootrestapplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="orders")
@EntityListeners(AuditingEntityListener.class)

public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
				
	private String products;
	
	private String nurseryName;
	

	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "add_id", referencedColumnName="address_id")
	private Address shippingAddress;
	
	private Integer total;

	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getNurseryName() {
		return nurseryName;
	}

	public void setNurseryName(String nurseryName) {
		this.nurseryName = nurseryName;
	}



	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
