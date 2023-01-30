package com.gms.webapi.service;

import java.util.List;


import com.gms.webapi.model.Seller;

public interface ISellerService {
List<Seller> getAllSeller();
Seller saveSeller(Seller s);
void deleteSellerById(Long s_id);
Seller updateSeller(Seller newSeller,Long s_id);
Seller findSellerByEmailAndPassword(String email,String password);
}
