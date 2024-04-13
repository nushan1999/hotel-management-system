/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.custom;

import Service.SuperService;
import dto.ReservationDto;
import dto.RoomDto;
import java.util.List;

/**
 *
 * @author Nushan Vandabona
 */
public interface ReservationService extends SuperService {

    String placeReservation(ReservationDto reservationDto) throws Exception;

    List<ReservationDto> getAll() throws Exception;

    ReservationDto getReservation(Integer reservationId) throws Exception;
    
    String deleteReservation(Integer reservationId) throws Exception; 

}
