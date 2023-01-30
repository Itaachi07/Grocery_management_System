package com.gms.webapi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.webapi.model.Customer;
import com.gms.webapi.repository.ICustomerRepository;
import com.gms.webapi.service.ICustomerService;

@Service
@Transactional
public class CustomerService implements ICustomerService {
	private ICustomerRepository customerRepository;

	@Autowired
	public CustomerService(ICustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomerById(Long c_id) {
		customerRepository.deleteCustomerById(c_id);
	}

	@Override
	public Customer updateCustomer(Customer newCustomer,Long c_id) {
		
		return customerRepository.findById(c_id)
			      .map(customer -> {
			    	  customer.setC_fname(newCustomer.getC_fname());
			    	  customer.setC_lname(newCustomer.getC_lname());
			    	  customer.setC_email(newCustomer.getC_email());
			    	  customer.setC_mobile(newCustomer.getC_mobile());
			    	  customer.setC_address(newCustomer.getC_address());
			    	  customer.setC_pincode(newCustomer.getC_pincode());
			    	  customer.setC_city(newCustomer.getC_city());
			    	  customer.setC_state(newCustomer.getC_state());
			        return customerRepository.save(customer);
			      })
			      .orElseGet(() -> {
			        newCustomer.setC_id(c_id);
			        return customerRepository.save(newCustomer);
			      });	}
}
