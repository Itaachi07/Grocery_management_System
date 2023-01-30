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
import com.gms.webapi.model.Product;
import com.gms.webapi.model.Seller;
import com.gms.webapi.service.IProductService;
import com.gms.webapi.service.ISellerService;

@RestController
@RequestMapping("/sellers")
@CrossOrigin("http://localhost:3000/")
public class SellerController {
	private IProductService productservice;
	private ISellerService sellerservice;
//	@Autowired
//	private FileUploadHelper fileuploadhelper;

	@Autowired
	public SellerController(IProductService productservice, ISellerService sellerservice) {
		super();
		this.productservice = productservice;
		this.sellerservice = sellerservice;

	}
	
	@PostMapping("/signup")
	public ResponseEntity<Seller> addSeller(@RequestBody Seller seller) {
		return new ResponseEntity<Seller>(sellerservice.saveSeller(seller), HttpStatus.CREATED);
	}

	@PostMapping("/products/add") 
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productservice.saveProduct(product), HttpStatus.CREATED);

	}

	@GetMapping("/products/{s_id}")
	public ResponseEntity<List<Product>> getParticularSellerProducts(@PathVariable("s_id") Long s_id) {
		Seller s = new Seller();
		s.setS_id(s_id);

		List<Product> list = productservice.getParticularSellerProducts(s);
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));

	}

	@PutMapping("/products/delete/{p_id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("p_id") Long p_id) {
		try {
			productservice.deleteProductById(p_id);
			return ResponseEntity.ok().body("Product Deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/products/update/{p_id}")
	ResponseEntity<Product> replaceProduct(@RequestBody Product newProduct, @PathVariable Long p_id) {
		Product product = null;
		try {
			product = productservice.updateProduct(newProduct, p_id);
			return ResponseEntity.ok().body(product);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

	@PostMapping("/signin_auth")
	public ResponseEntity<Optional<Seller>> loginSeller(@RequestBody Seller s) {
		Seller seller = null;
		try {
			seller = sellerservice.findSellerByEmailAndPassword(s.getS_email(), s.getS_password());
			return ResponseEntity.ok(Optional.of(seller));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//	@PostMapping("/products/fileupload")
//	public ResponseEntity<String> saveProductFile(@RequestParam("file") MultipartFile file) {
//		boolean f = fileuploadhelper.uploadFile(file);
//		if (f == true) {
//			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/products/")
//					.path(file.getOriginalFilename()).toUriString());
//		}
//		return ResponseEntity.internalServerError().body("Something Went Wrong");
//	}

}