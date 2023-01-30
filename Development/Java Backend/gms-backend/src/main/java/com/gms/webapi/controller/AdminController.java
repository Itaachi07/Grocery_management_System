package com.gms.webapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gms.webapi.model.Customer;
import com.gms.webapi.model.Product;
import com.gms.webapi.model.Seller;
import com.gms.webapi.service.impl.CustomerService;
import com.gms.webapi.service.impl.ProductService;
import com.gms.webapi.service.impl.SellerService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins  = "*")
public class AdminController {
	private SellerService sellerservice;
	private ProductService productService;
	private CustomerService customerService;

	@GetMapping("/sellers_list")
	public ResponseEntity<List<Seller>> getAllSeller() {
		List<Seller> list = sellerservice.getAllSeller();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@Autowired
	public AdminController(SellerService sellerservice, ProductService productService,
			CustomerService customerService) {
		super();
		this.sellerservice = sellerservice;
		this.productService = productService;
		this.customerService = customerService;
	}

	

	@GetMapping("/products_list")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> list = productService.getAllProducts();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/customers_list")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = customerService.getAllCustomers();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));

	}

	@PutMapping("/sellers/delete/{s_id}")
	public ResponseEntity<String> deleteSellerById(@PathVariable("s_id") Long s_id) {
		try {
			sellerservice.deleteSellerById(s_id);
			return ResponseEntity.ok().body("Deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/products/delete/{p_id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("p_id") Long p_id) {
		try {
			productService.deleteProductById(p_id);
			return ResponseEntity.ok().body("Product Deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/customers/delete/{c_id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("c_id") Long c_id) {
		try {
			customerService.deleteCustomerById(c_id);
			return ResponseEntity.ok().body("Customer Deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/customers/update/{c_id}")
	ResponseEntity<Customer> replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long c_id) {
		Customer cust = null;
		try {
			cust = customerService.updateCustomer(newCustomer, c_id);
			return ResponseEntity.ok().body(cust);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/sellers/update/{s_id}")
	ResponseEntity<Seller> replaceSeller(@RequestBody Seller newSeller, @PathVariable Long s_id) {
		Seller seller = null;
		try {
			seller = sellerservice.updateSeller(newSeller, s_id);
			return ResponseEntity.ok().body(seller);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
