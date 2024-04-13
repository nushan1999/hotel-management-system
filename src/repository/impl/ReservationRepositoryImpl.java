/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import entity.ReservationEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.ReservationRepository;

/**
 *
 * @author Nushan Vandabona
 */
public class ReservationRepositoryImpl implements ReservationRepository {

    @Override
    public Integer placeReservation(ReservationEntity reservationEntity, Session session) throws Exception {
        Integer id = (Integer) session.save(reservationEntity);
        return id;
    }

    @Override
    public List<ReservationEntity> getAllReservations(Session session) throws Exception {
        String hql = "FROM ReservationEntity";
        Query<ReservationEntity> query = session.createQuery(hql);
        List<ReservationEntity> reservationEntities = query.list();
        return reservationEntities;
    }

    @Override
    public ReservationEntity getReservation(Integer reservationId, Session session) throws Exception {
        ReservationEntity reservationEntity = session.get(ReservationEntity.class, reservationId);
        return reservationEntity;
    }

    @Override
    public void deleteReservation(ReservationEntity reservationEntity, Session session) throws Exception {
        session.delete(reservationEntity);
    }

}
