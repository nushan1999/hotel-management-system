/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Service.ServiceFactory;
import Service.custom.UserService;

/**
 *
 * @author Nushan Vandabona
 */
public class UserController {

    private UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);

    public boolean authenticate(String username, String password) throws Exception {
        return userService.authenticate(username, password);
    }

}
