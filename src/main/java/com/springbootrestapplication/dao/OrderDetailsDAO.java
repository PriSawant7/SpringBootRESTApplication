package com.springbootrestapplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestapplication.model.OrderDetails;
import com.springbootrestapplication.repository.OrderDetailsRepository;

@Service
public class OrderDetailsDAO {
	
	@Autowired
	OrderDetailsRepository orderRepository;
	
	
	public OrderDetails save(OrderDetails or) {
		return orderRepository.save(or);
	}
	
	
	
	public List<OrderDetails> findAll(){
		return orderRepository.findAll();
	}
	
	
	public OrderDetails getOne(Long orderId) {
		return orderRepository.getOne(orderId);
	}
	
	
	
	public void delete(OrderDetails or) {
		orderRepository.delete(or);
	}
	

}
