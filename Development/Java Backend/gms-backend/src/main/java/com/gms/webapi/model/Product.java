package com.gms.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long p_id;
	@ManyToOne
	@JoinColumn(name = "cat_id")
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Category cat_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "s_id")
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Seller s_id;
	@Column(length = 100)
	private String p_name;
	private double p_price;
	@Column(length = 20)
	private String p_unit;
	@Column(length = 800)
	private String p_details;
	@Column(length = 500)
	private String p_image_path;
	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private boolean isDeleted;
}
