package com.springbootrestapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapplication.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
	
}