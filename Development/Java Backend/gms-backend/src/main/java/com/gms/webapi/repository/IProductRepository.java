package com.gms.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gms.webapi.model.Product;
import com.gms.webapi.model.Seller;

public interface IProductRepository extends JpaRepository<Product, Long> {
	@Query("select p from Product p where p.s_id= :s_id and p.isDeleted=false")
	List<Product> getParticularSellerProducts(@Param("s_id") Seller s_id);

	@Modifying
	@Query("update Product p set isDeleted=true where p_id=:p_id")
	void deleteProductById(@Param("p_id") Long p_id);
}
