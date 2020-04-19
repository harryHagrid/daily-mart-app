package com.training.dailymartapi.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PurchaseOrder {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long orderId;
	
	@OneToOne
	private Product product;
	
	private int quantity;
	
	@OneToOne
	private AppUser purchasedBy;
	
	private double totalPrice;
	
	private LocalDate purchasedOn;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public AppUser getPurchasedBy() {
		return purchasedBy;
	}

	public void setPurchasedBy(AppUser purchasedBy) {
		this.purchasedBy = purchasedBy;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getPurchasedOn() {
		return purchasedOn;
	}

	public void setPurchasedOn(LocalDate purchasedOn) {
		this.purchasedOn = purchasedOn;
	}
	
	

}
