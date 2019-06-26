package com.springbootrestapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapplication.dao.ProductDAO;
import com.springbootrestapplication.model.Product;

@RestController
@RequestMapping("/plantt")
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;
	
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product pro) {
		return productDAO.save(pro);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productDAO.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value="id") Long productId){
		
		Product pro=productDAO.getOne(productId);
		
		if(pro==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pro);
		
	}
	
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value="id") Long productId,@Valid @RequestBody Product proDetails){
		
		Product pro=productDAO.getOne(productId);
		if(pro==null) {
			return ResponseEntity.notFound().build();
		}
		
		pro.setName(proDetails.getName());
		pro.setDescription(proDetails.getDescription());
		pro.setPrice(proDetails.getPrice());
		
		Product updateProduct=productDAO.save(pro);
		return ResponseEntity.ok().body(updateProduct);
		
		
		
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value="id") Long productId){
		
		Product pro=productDAO.getOne(productId);
		if(pro==null) {
			return ResponseEntity.notFound().build();
		}
		productDAO.delete(pro);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
