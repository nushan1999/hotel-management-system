/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Service.ServiceFactory;
import Service.custom.CustomerService;
import dto.CustomerDto;
import java.util.List;

/**
 *
 * @author Nushan Vandabona
 */
public class CustomerController {
    
    private CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public String saveCustomer(CustomerDto customerDto) throws Exception {
        return customerService.saveCustomer(customerDto);
    }
    
    public String updateCustomer(CustomerDto customerDto) throws Exception {
        return customerService.updateCustomer(customerDto);
    }
    
    public String deleteCustomer(Integer customerId) throws Exception {
        return customerService.deleteCustomer(customerId);
    }
    
    public CustomerDto getCustomer(Integer customerId) throws Exception {
        return customerService.getCustomer(customerId);
    }
    
    public List<CustomerDto> getAll() throws Exception {
        return customerService.getAll();
    }
    
}
