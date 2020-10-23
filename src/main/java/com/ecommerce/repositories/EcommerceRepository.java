package com.ecommerce.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Customer;
import com.ecommerce.models.Orders;

@Repository
public interface EcommerceRepository extends JpaRepository<Customer, Integer>{
	
    // Query method
	Customer findTop1ByOrderByCustomerIDDesc();
	
	List<Customer> findAllByOrderByCustomerNameAsc();
}