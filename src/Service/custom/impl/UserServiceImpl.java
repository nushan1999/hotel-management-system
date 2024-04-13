/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.custom.impl;

import Service.custom.UserService;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.RepositoryFactory;
import repository.custom.UserRepository;
import util.SessionFactoryConfiguration;

/**
 *
 * @author Nushan Vandabona
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository = (UserRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.USER);

    @Override
    public boolean authenticate(String username, String password) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            UserEntity userEntity = userRepository.findByUsername(username, session);
            transaction.commit();

            if (userEntity != null && userEntity.getPassword().equals(password)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

}
