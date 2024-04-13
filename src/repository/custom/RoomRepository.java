/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.custom;

import entity.RoomEntity;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import repository.SuperRepository;

/**
 *
 * @author Nushan Vandabona
 */
public interface RoomRepository extends SuperRepository {

    Integer saveRoom(RoomEntity roomEntity, Session session) throws Exception;

    RoomEntity getRoom(Integer roomId, Session session) throws Exception;

    void updateRoom(RoomEntity roomEntity, Session session) throws Exception;

    void deleteRoom(RoomEntity roomEntity, Session session) throws Exception;

    List<RoomEntity> getAllRooms(Session session) throws Exception;
    
    boolean isRoomAvailable (Integer roomId,Date checkInDate, Date checkOutDate, Session session);
}
