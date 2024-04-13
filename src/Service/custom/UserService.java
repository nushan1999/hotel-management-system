/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.custom;

import Service.SuperService;

/**
 *
 * @author Nushan Vandabona
 */
public interface UserService extends SuperService {
    
    boolean authenticate(String username, String password);
    
}
