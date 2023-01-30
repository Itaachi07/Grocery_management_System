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
public class Customer {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long c_id;
    @Column(length = 50)
    private String c_fname;
    @Column(length = 50)
    private String c_lname;
    @Column(unique = true,length = 100)
    private String c_email;
    @Column(unique = true,length = 20)
    private String c_mobile;
    @Column(length = 300)
    private String c_password;
    @Column(length = 200)
    private String c_address;
	@Column(length = 6)
	private int c_pincode;
	@Column(length = 100)
	private String c_city;
	@Column(length = 100)
	private String c_state;
    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isDeleted;
}

