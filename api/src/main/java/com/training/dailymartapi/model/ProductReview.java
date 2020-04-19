package com.training.dailymartapi.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProductReview {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long rid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	private String reviewText;
	
	private double rating;
	
	private LocalDate createdOn;
	
	@ManyToOne
	private AppUser reviewedBy;

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public AppUser getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(AppUser reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	
	

}
