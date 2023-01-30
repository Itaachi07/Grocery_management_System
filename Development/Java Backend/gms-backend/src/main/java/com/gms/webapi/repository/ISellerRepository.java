package com.gms.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gms.webapi.model.Seller;

public interface ISellerRepository extends JpaRepository<Seller, Long> {
	@Modifying
	@Query("update Seller s set isDeleted=true where s_id=:s_id")
	void deleteSellerById(@Param("s_id") Long s_id);

	@Query("select s from Seller s where s.s_email=:s_email and s.s_password=:s_password and is_deleted=false")
	Seller findSellerByS_emailAndS_password(@Param("s_email") String email, @Param("s_password") String password);

}
