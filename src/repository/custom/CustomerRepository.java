/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.custom;

import entity.CustomerEntity;
import java.util.List;
import org.hibernate.Session;
import repository.SuperRepository;

/**
 *
 * @author Nushan Vandabona
 */
public interface CustomerRepository extends SuperRepository {

    Integer saveCustomer(CustomerEntity customerEntity, Session session) throws Exception;

    CustomerEntity getCustomer(Integer customerId, Session session) throws Exception;

    void updateCustomer(CustomerEntity customerEntity, Session session) throws Exception;

    void deleteCustomer(CustomerEntity customerEntity, Session session) throws Exception;

    List<CustomerEntity> getAllCustomers(Session session) throws Exception;
}
