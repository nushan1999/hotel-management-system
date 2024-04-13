/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.custom;

import entity.ReservationEntity;
import entity.RoomEntity;
import java.util.List;
import org.hibernate.Session;
import repository.SuperRepository;

/**
 *
 * @author Nushan Vandabona
 */
public interface ReservationRepository extends SuperRepository {

    Integer placeReservation(ReservationEntity reservationEntity, Session session) throws Exception;

    List<ReservationEntity> getAllReservations(Session session) throws Exception;

    ReservationEntity getReservation(Integer reservationId, Session session) throws Exception;
    
    void deleteReservation(ReservationEntity reservationEntity, Session session) throws Exception;

}
