/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.hibernate.Session;
import util.SessionFactoryConfiguration;
import view.CustomerView;
import view.ReservationView;
import view.RoomCategoryView;
import view.RoomView;

/**
 *
 * @author Nushan Vandabona
 */
public class Main {

    public static void main(String[] args) {
        new CustomerView().setVisible(true);
        new RoomCategoryView().setVisible(true);
        new RoomView().setVisible(true);
        new ReservationView().setVisible(true);
    }
}
