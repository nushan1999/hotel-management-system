/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.custom;

import entity.UserEntity;
import org.hibernate.Session;
import repository.SuperRepository;

/**
 *
 * @author Nushan Vandabona
 */
public interface UserRepository extends SuperRepository {

    UserEntity findByUsername(String username, Session session) throws Exception;
}
