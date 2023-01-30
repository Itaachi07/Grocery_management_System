package com.gms.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gms.webapi.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
	@Modifying
	@Query("update Customer c set isDeleted=true where c_id=:c_id")
	void deleteCustomerById(@Param("c_id") Long c_id);


}
