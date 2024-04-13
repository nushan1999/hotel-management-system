/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.custom;

import Service.SuperService;
import dto.CustomerDto;
import java.util.List;

/**
 *
 * @author Nushan Vandabona
 */
public interface CustomerService extends SuperService {

    String saveCustomer(CustomerDto customerDto) throws Exception;

    String updateCustomer(CustomerDto customerDto) throws Exception;

    String deleteCustomer(Integer customerId) throws Exception;

    CustomerDto getCustomer(Integer customerId) throws Exception;

    List<CustomerDto> getAll() throws Exception;
  
}
