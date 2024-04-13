/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import repository.impl.CustomerRepositoryImpl;
import repository.impl.ReservationRepositoryImpl;
import repository.impl.RoomCategoryRepositoryImpl;
import repository.impl.RoomRepositoryImpl;
import repository.impl.UserRepositoryImpl;

/**
 *
 * @author Nushan Vandabona
 */
public class RepositoryFactory {

    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryType repositoryType) {
        switch (repositoryType) {
            case CUSTOMER:
                return new CustomerRepositoryImpl();
            case ROOM:
                return new RoomRepositoryImpl();
            case ROOMCATEGORY:
                return new RoomCategoryRepositoryImpl();
            case RESERVATION:
                return new ReservationRepositoryImpl();
            case USER:
                return new UserRepositoryImpl();
            default:
                return null;
        }
    }

    public enum RepositoryType {
        CUSTOMER, ROOM, ROOMCATEGORY, RESERVATION, USER
    }
}
