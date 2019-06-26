package com.springbootrestapplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestapplication.model.Product;
import com.springbootrestapplication.repository.ProductRepository;

@Service
public class ProductDAO {
	
	@Autowired
	ProductRepository productRepository;
		
	public Product save(Product pro) {
		return productRepository.save(pro);
	}
	
		
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	
	public Product getOne(Long productId) {
		return productRepository.getOne(productId);
	}
	
		
	public void delete(Product pro) {
		productRepository.delete(pro);
	}
	

}
