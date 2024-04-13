/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Service.ServiceFactory;
import Service.custom.ReservationService;
import dto.ReservationDto;
import java.util.List;

/**
 *
 * @author Nushan Vandabona
 */
public class ReservationController {

    private ReservationService reservationService = (ReservationService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RESERVATION);

    public String placeReservation(ReservationDto reservationDto) throws Exception {
        return reservationService.placeReservation(reservationDto);
    }

    public List<ReservationDto> getAll() throws Exception {
        return reservationService.getAll();
    }

    public ReservationDto getReservation(Integer reservationId) throws Exception {
        return reservationService.getReservation(reservationId);
    }

    public String deleteReservation(Integer reservationId) throws Exception {
        return reservationService.deleteReservation(reservationId);
    }

}
