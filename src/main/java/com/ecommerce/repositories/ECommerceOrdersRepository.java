package com.ecommerce.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Customer;
import com.ecommerce.models.Orders;

@Repository
public interface ECommerceOrdersRepository extends JpaRepository<Orders, Integer>{
	
    // Query method
	//Customer findTop1ByOrderByCustomerIDDesc();
}