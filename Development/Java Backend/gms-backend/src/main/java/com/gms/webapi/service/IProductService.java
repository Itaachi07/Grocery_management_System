package com.gms.webapi.service;



import java.util.List;


import com.gms.webapi.model.Product;
import com.gms.webapi.model.Seller;

public interface IProductService {
	Product saveProduct(Product product);
	List<Product> getParticularSellerProducts(Seller s_id);
	
	void deleteProductById(Long p_id);
	
	List<Product> getAllProducts();
	Product updateProduct(Product newProduct,Long p_id);

}
