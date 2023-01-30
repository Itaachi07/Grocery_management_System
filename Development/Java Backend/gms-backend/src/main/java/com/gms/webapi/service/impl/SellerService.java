package com.gms.webapi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.webapi.model.Seller;
import com.gms.webapi.repository.ISellerRepository;
import com.gms.webapi.service.ISellerService;

@Service
@Transactional
public class SellerService implements ISellerService {
	private ISellerRepository sellerrepository;

	@Autowired
	public SellerService(ISellerRepository sellerrepository) {
		super();
		this.sellerrepository = sellerrepository;
	}

	@Override
	public List<Seller> getAllSeller() {
		// TODO Auto-generated method stub
		return sellerrepository.findAll();
	}

	@Override
	public Seller saveSeller(Seller s) {
		return sellerrepository.save(s);
	}

	@Override
	public void deleteSellerById(Long s_id) {
		sellerrepository.deleteSellerById(s_id);
	}

	@Override
	public Seller updateSeller(Seller newSeller, Long s_id) {
		return sellerrepository.findById(s_id)
			      .map(seller -> {
			    	  seller.setS_name(newSeller.getS_name());
			    	  seller.setS_email(newSeller.getS_email());
			    	  seller.setS_mobile(newSeller.getS_mobile());
			    	  seller.setS_password(newSeller.getS_password());
			    	  seller.setS_pincode(newSeller.getS_pincode());
			    	  seller.setS_city(newSeller.getS_city());
			    	  seller.setS_state(newSeller.getS_state());
			    	  seller.setDeleted(newSeller.isDeleted());
			        return sellerrepository.save(seller);
			      })
			      .orElseGet(() -> {
			        newSeller.setS_id(s_id);
			        return sellerrepository.save(newSeller);
			      });	}

	@Override
	public Seller findSellerByEmailAndPassword(String email, String password) {
		Seller seller=sellerrepository.findSellerByS_emailAndS_password(email, password);
		return seller;
	}	

}
