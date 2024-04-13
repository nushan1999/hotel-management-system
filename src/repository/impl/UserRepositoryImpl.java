/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import entity.UserEntity;
import org.hibernate.Session;
import repository.custom.UserRepository;

/**
 *
 * @author Nushan Vandabona
 */
public class UserRepositoryImpl implements UserRepository {

    @Override
    public UserEntity findByUsername(String username, Session session) throws Exception {
        String hql = "FROM UserEntity WHERE username = :username";
        return session.createQuery(hql, UserEntity.class)
                .setParameter("username", username)
                .uniqueResult();
    }
}
