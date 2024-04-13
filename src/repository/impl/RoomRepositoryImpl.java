/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import entity.RoomEntity;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.RoomRepository;

/**
 *
 * @author Nushan Vandabona
 */
public class RoomRepositoryImpl implements RoomRepository {

    @Override
    public Integer saveRoom(RoomEntity roomEntity, Session session) throws Exception {
        Integer id = (Integer) session.save(roomEntity);
        return id;
    }

    @Override
    public RoomEntity getRoom(Integer roomId, Session session) throws Exception {
        RoomEntity roomEntity = session.get(RoomEntity.class, roomId);
        return roomEntity;
    }

    @Override
    public void updateRoom(RoomEntity roomEntity, Session session) throws Exception {
        session.update(roomEntity);
    }

    @Override
    public void deleteRoom(RoomEntity roomEntity, Session session) throws Exception {
        session.delete(roomEntity);
    }

    @Override
    public List<RoomEntity> getAllRooms(Session session) throws Exception {
        String hql = "FROM RoomEntity";
        Query<RoomEntity> query = session.createQuery(hql);
        List<RoomEntity> roomEntities = query.list();
        return roomEntities;
    }

    @Override
    public boolean isRoomAvailable(Integer roomId, Date checkInDate, Date checkOutDate, Session session) {
        String hql = "SELECT count(*) FROM ReservationEntity WHERE room.roomId = :roomId AND NOT (checkOutDate <= :checkIn OR checkInDate >= :checkOut)";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("roomId", roomId);
        query.setParameter("checkIn", checkInDate);
        query.setParameter("checkOut", checkOutDate);
        return query.uniqueResult() == 0; // Returns true if no overlapping reservations are found
    }

}
