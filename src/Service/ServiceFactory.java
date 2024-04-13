/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Service.custom.impl.CustomerServiceImpl;
import Service.custom.impl.ReservationServiceImpl;
import Service.custom.impl.RoomCategoryServiceImpl;
import Service.custom.impl.RoomServiceImpl;
import Service.custom.impl.UserServiceImpl;

/**
 *
 * @author Nushan Vandabona
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }

        return serviceFactory;
    }

    public SuperService getService(ServiceType serviceType) {
        switch (serviceType) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case RESERVATION:
                return new ReservationServiceImpl();
            case ROOMCATEGORY:
                return new RoomCategoryServiceImpl();
            case ROOM:
                return new RoomServiceImpl();
            case USER:
                return new UserServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType {
        CUSTOMER, RESERVATION, ROOMCATEGORY, ROOM, USER
    }
}
