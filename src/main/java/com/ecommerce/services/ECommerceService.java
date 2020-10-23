package com.ecommerce.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Customer;
import com.ecommerce.models.Orders;
import com.ecommerce.repositories.ECommerceOrdersRepository;
import com.ecommerce.repositories.EcommerceRepository;

@Service
public class ECommerceService implements IEcommerce {
	
	private static Logger logger = Logger.getLogger(ECommerceService.class);
    
	@Autowired
    EcommerceRepository custRepo;
    
	@Autowired
    ECommerceOrdersRepository orderRepo;
 
    /* Service to get ALL customers sort by customer name
     * 
     * (non-Javadoc)
     * @see com.ecommerce.services.IEcommerce#getAllCustomers()
     */
    @Override
    public List<Customer> getAllCustomers() {
        return custRepo.findAllByOrderByCustomerNameAsc();//Sort customer Name by asc
    }

    /* 
     * Service to save customer details
     * 
     * (non-Javadoc)
     * @see com.ecommerce.services.IEcommerce#save(com.ecommerce.models.Customer)
     */
    @Override
    public String save(Customer std) {
    	String status = "Created New Customer";
    	try{
         custRepo.save(std);
    	}catch(Exception e){
    		status = "Error Occured While Inserting new Customer";
    		logger.error("Error While Saving customer Details--"+e.getMessage());
    	}
         return status;
    }
    
    /* 
     * Service to save Order details by last inserted cust id
     * 
     * (non-Javadoc)
     * @see com.ecommerce.services.IEcommerce#saveByLastInsertedCustomerId(com.ecommerce.models.Orders)
     */
    @Override
    public String saveByLastInsertedCustomerId(Orders std) {
    	String status = "Created Order for Last Inserted Customer";
    	try{
    		Customer cust = custRepo.findTop1ByOrderByCustomerIDDesc();
    		std.setCustomer(cust);
    		orderRepo.save(std);
    	}catch(Exception e){
    		status = "Error Occured While Inserting Order";
    		logger.error("Error While Saving OrderDetails Details by Last customer id--"+e.getMessage());
    	}
         return status;
    }
    
    /* 
     * Service to save Order details 
     * 
     * (non-Javadoc)
     * @see com.ecommerce.services.IEcommerce#saveByCustomerId(com.ecommerce.models.Orders)
     */
    @Override
    public String saveByCustomerId(Orders std) {
    	String status = "Created Order for Customer Given";
    	try{
    		orderRepo.save(std);
    	}catch(Exception e){
    		status = "Error Occured While Inserting Order";
    		logger.error("Error While Saving Order Details--"+e.getMessage());
    	}
         return status;
    }

}