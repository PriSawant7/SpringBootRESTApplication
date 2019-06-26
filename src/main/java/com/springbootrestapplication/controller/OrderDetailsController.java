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

import com.springbootrestapplication.dao.OrderDetailsDAO;
import com.springbootrestapplication.model.OrderDetails;

@RestController
@RequestMapping("/plantt")
public class OrderDetailsController {
	
	@Autowired
	OrderDetailsDAO orderDetailsDAO;
	
	@PostMapping("/order")
	public OrderDetails createOrder(@Valid @RequestBody OrderDetails ord) {
		return orderDetailsDAO.save(ord);
	}
	
	@GetMapping("/order")
	public List<OrderDetails> getAllOrders(){
		return orderDetailsDAO.findAll();
	}
	
	
	@PutMapping("/order/{id}")
	public ResponseEntity<OrderDetails> updateOrder(@PathVariable(value="id") Long orderId,@Valid @RequestBody OrderDetails orderDetails){
		
		OrderDetails ord=orderDetailsDAO.getOne(orderId);
		if(ord==null) {
			return ResponseEntity.notFound().build();
		}
		
		ord.setProducts(orderDetails.getProducts());
		ord.setShippingAddress(orderDetails.getShippingAddress());
		ord.setTotal(orderDetails.getTotal());
		ord.setNurseryName(orderDetails.getNurseryName());
		
		OrderDetails updateOrder=orderDetailsDAO.save(ord);
		return ResponseEntity.ok().body(updateOrder);
		
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<OrderDetails> deleteOrder(@PathVariable(value="id") Long orderId){
		
		OrderDetails ord=orderDetailsDAO.getOne(orderId);
		if(ord==null) {
			return ResponseEntity.notFound().build();
		}
		orderDetailsDAO.delete(ord);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
