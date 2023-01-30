package com.gms.webapi.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gms.webapi.model.Product;
import com.gms.webapi.model.Seller;
import com.gms.webapi.repository.IProductRepository;
import com.gms.webapi.service.IProductService;

@Service
@Transactional
public class ProductService implements IProductService {
	private IProductRepository productrepository;

	@Autowired 
	public ProductService(IProductRepository productrepository) {
		super();
		this.productrepository = productrepository;
	}

	@Override
	public Product saveProduct(Product product) {
		return productrepository.save(product);
	}

	@Override
	public List<Product> getParticularSellerProducts(Seller s_id) {
		// TODO Auto-generated method stub
		return productrepository.getParticularSellerProducts(s_id);
	}

	@Override
	public void deleteProductById(Long p_id) {
		// TODO Auto-generated method stub
		 productrepository.deleteProductById(p_id);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productrepository.findAll();
	}

	@Override
	public Product updateProduct(Product newProduct, Long p_id) {
		return productrepository.findById(p_id)
			      .map(product -> {
			    	  product.setP_name(newProduct.getP_name());
			    	  product.setP_price(newProduct.getP_price());
			    	  product.setP_unit(newProduct.getP_unit());
			    	  product.setP_details(newProduct.getP_details());
			    	  product.setP_image_path(newProduct.getP_image_path());
			    	  
			        return productrepository.save(product);
			      })
			      .orElseGet(() -> {
			        newProduct.setP_id(p_id);
			        return productrepository.save(newProduct);
			      });	}

	
	


}
