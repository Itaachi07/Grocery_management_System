package com.gms.webapi.service;

import java.util.List;

import com.gms.webapi.model.Customer;

public interface ICustomerService {
	List<Customer> getAllCustomers();
	void deleteCustomerById(Long c_id);
	Customer updateCustomer(Customer newCustomer,Long c_id);
	
}
