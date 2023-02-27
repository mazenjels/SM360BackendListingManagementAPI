package com.sm360.listing.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.sm360.listing.request.ListingRequest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tb_listing")
public class Listing {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false)
	private UUID id;
	
	@NotNull(message= "Dealer info can not be null")
	@Column(name = "dealer_id")
	private UUID dealerId;
	
	
	@NotBlank(message= "Please enter vehicle info")
	private String vehicle;
	

	private double price=0.0;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable=false, updatable=false)	
	private Date createdAt;
	
	@CreationTimestamp
	@Column(name = "updated_at",updatable=false)	
	private Date updatedAt;
	
	private String state="draft";


	


	public UUID getDealerId() {
		return dealerId;
	}
	public void setDealerId(UUID dealerId) {
		this.dealerId = dealerId;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public double getPrice() {
		BigDecimal bd = new BigDecimal(price);
		price = (bd.setScale(2, RoundingMode.HALF_DOWN)).doubleValue();
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	/*
	 * @PrePersist public void onCreate() { createdat = new Date(); }
	 */
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
	
}
