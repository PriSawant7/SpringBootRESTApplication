package com.springbootrestapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapplication.model.OrderDetails;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}