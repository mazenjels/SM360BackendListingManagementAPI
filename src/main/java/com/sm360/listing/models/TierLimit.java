package com.sm360.listing.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tb_tier_limit")
public class TierLimit {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false)
	private UUID id ;
	
	@NotNull(message= "Dealer info can not be null")
	@Column(name = "dealer_id",unique=true)
	private UUID dealerId;
	
	@Min(value = 1, message = "Number of published listing must be greater or equal to 1")
	@Column(name = "nb_of_published_listings")
	private int nbOfPublishedListing;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable=false, updatable=false)	
	private Date createdAt;

	public TierLimit() {
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getDealerId() {
		return dealerId;
	}

	public void setDealerId(UUID dealerId) {
		this.dealerId = dealerId;
	}

	public int getNbOfPublishedListing() {
		return nbOfPublishedListing;
	}

	public void setNbOfPublishedListing(int nbOfPublishedListing) {
		this.nbOfPublishedListing = nbOfPublishedListing;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
