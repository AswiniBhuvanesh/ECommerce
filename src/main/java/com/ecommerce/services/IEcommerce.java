package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Customer;
import com.ecommerce.models.Orders;

public interface IEcommerce {
	
    List<Customer> getAllCustomers();
    
    String save(Customer std);
    
    String saveByLastInsertedCustomerId(Orders std);
    
    String saveByCustomerId(Orders std);
    
    
    
}