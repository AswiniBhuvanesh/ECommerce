package com.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.Customer;
import com.ecommerce.models.Orders;
import com.ecommerce.services.ECommerceService;
import io.swagger.annotations.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Hidden;

@Api(value = "ECommerceController", description = "REST Apis related to Customer and Orders Entity!!!!")
@RestController
@RequestMapping("/api")
public class ECommerceController {
	

	
	@Autowired
    ECommerceService eCommerceservice;
    
	
    /**
     * Method to get All customers with Order Details
     * 
     * @return
     */
	@ApiOperation(value = "Get list of Customers and its Order Details ", response = Iterable.class, tags = "e-commerce")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping(value="/customers")
    public List<Customer> getAllCustomerDetails(){
        return  eCommerceservice.getAllCustomers();
    }           
            
    /**
     * Method to Insert Customer 
     * 
     * @param cust
     * @return
     */
	@ApiOperation(value = "Add Customers", response = Iterable.class, tags = "e-commerce")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping(value="/addCustomer")
    public String addCustomer(@Valid @RequestBody Customer cust) {
        return eCommerceservice.save(cust);
    }
    
    /**
     * Method to Insert Order Details by last Inserted Customer Id
     * 
     * @param ord
     * @return
     */
	@ApiOperation(value = "Add Orders By last Inserted Customer Id", response = Iterable.class, tags = "e-commerce")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping(value="/addOrdersByLastInsertedCustId")
    public String addOrdersByLastInsertedCustomer(@Valid @RequestBody Orders ord) {
        return eCommerceservice.saveByLastInsertedCustomerId(ord);
    }
    
    
    
    /**
     * Method to insert order details by providing cust id
     * 
     * @param ord
     * @return
     */
    @PostMapping(value="/addOrdersByCustId")
    public String addOrdersByCustomerId(@Valid @RequestBody Orders ord) {
        return eCommerceservice.saveByCustomerId(ord);
    }
    
 

}
