/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.custom.impl;

import Service.custom.CustomerService;
import dto.CustomerDto;
import entity.CustomerEntity;
import entity.ReservationEntity;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.RepositoryFactory;
import repository.custom.CustomerRepository;
import repository.custom.ReservationRepository;
import util.SessionFactoryConfiguration;

/**
 *
 * @author Nushan Vandabona
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = (CustomerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.CUSTOMER);

    @Override
    public String saveCustomer(CustomerDto customerDto) throws Exception {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setCustomerName(customerDto.getCustomerName());
            customerEntity.setAddress(customerDto.getAddress());
            customerEntity.setEmail(customerDto.getEmail());
            customerEntity.setPhoneNumber(customerDto.getPhoneNumber());
            Integer customerId = customerRepository.saveCustomer(customerEntity, session);
            if (customerId != null) {
                transaction.commit();
                return "Customer Saved Successfully";
            } else {
                transaction.rollback();
                return "Customer Save Error";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String updateCustomer(CustomerDto customerDto) throws Exception {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            CustomerEntity customerEntity = customerRepository.getCustomer(customerDto.getCustomerId(), session);
            if (customerEntity == null) {
                transaction.rollback();
                return "Customer Not Found";
            } else {
                customerEntity.setCustomerName(customerDto.getCustomerName());
                customerEntity.setAddress(customerDto.getAddress());
                customerEntity.setEmail(customerDto.getEmail());
                customerEntity.setPhoneNumber(customerDto.getPhoneNumber());
                customerRepository.updateCustomer(customerEntity, session);
                transaction.commit();
                return "Customer Updated Successfully";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String deleteCustomer(Integer customerId) throws Exception {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            CustomerEntity customerEntity = customerRepository.getCustomer(customerId, session);
            if (customerEntity == null) {
                transaction.rollback();
                return "Customer Not Found";
            } else {
                customerRepository.deleteCustomer(customerEntity, session);
                transaction.commit();
                return "Customer Deleted Successfully";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public CustomerDto getCustomer(Integer customerId) throws Exception {

        Session session = null;

        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            CustomerEntity customerEntity = customerRepository.getCustomer(customerId, session);
            if (customerEntity != null) {
                CustomerDto customerDto = new CustomerDto(
                        customerEntity.getCustomerName(),
                        customerEntity.getEmail(),
                        customerEntity.getPhoneNumber(),
                        customerEntity.getAddress());
                customerDto.setCustomerId(customerEntity.getCustomerId());
                return customerDto;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CustomerDto> getAll() throws Exception {
        Session session = null;
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            List<CustomerEntity> customerEntities = customerRepository.getAllCustomers(session);
            List<CustomerDto> customerDtos = new ArrayList<>();
            for (CustomerEntity entity : customerEntities) {
                CustomerDto dto = new CustomerDto(
                        entity.getCustomerId(),
                        entity.getCustomerName(),
                        entity.getEmail(),
                        entity.getPhoneNumber(),
                        entity.getAddress());
                customerDtos.add(dto);
            }
            return customerDtos;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
