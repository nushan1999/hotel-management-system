/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import entity.CustomerEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.CustomerRepository;

/**
 *
 * @author Nushan Vandabona
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Integer saveCustomer(CustomerEntity customerEntity, Session session) throws Exception {
        Integer id = (Integer) session.save(customerEntity);
        return id;
    }

    @Override
    public CustomerEntity getCustomer(Integer customerId, Session session) throws Exception {
        CustomerEntity customerEntity = session.get(CustomerEntity.class, customerId);
        return customerEntity;
    }

    @Override
    public void updateCustomer(CustomerEntity customerEntity, Session session) throws Exception {
        session.update(customerEntity);
    }

    @Override
    public void deleteCustomer(CustomerEntity customerEntity, Session session) throws Exception {
        session.delete(customerEntity);
    }
    
    @Override
    public List<CustomerEntity> getAllCustomers(Session session) throws Exception {
        String hql ="FROM CustomerEntity";
        Query<CustomerEntity> query = session.createQuery(hql);
        List<CustomerEntity> customerEntities = query.list();
        return customerEntities;
    }

}
