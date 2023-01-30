package com.gms.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long s_id;
	@Column(length = 100)
	private String s_name;
	@Column(length = 100, unique = true)
	private String s_email;
	@Column(length = 20, unique = true)
	private String s_mobile;
	@Column(length = 300)
	private String s_password;
	@Column(length = 6)
	private int s_pincode;
	@Column(length = 100)
	private String s_city;
	@Column(length = 100)
	private String s_state;
	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private boolean isDeleted;
}
