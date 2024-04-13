/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import entity.RoomCategoryEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.RoomCategoryRepository;

/**
 *
 * @author Nushan Vandabona
 */
public class RoomCategoryRepositoryImpl implements RoomCategoryRepository {

    @Override
    public Integer saveRoomCategory(RoomCategoryEntity roomCategoryEntity, Session session) throws Exception {
        Integer id = (Integer) session.save(roomCategoryEntity);
        return id;
    }

    @Override
    public RoomCategoryEntity getRoomCategory(Integer categoryId, Session session) throws Exception {
        RoomCategoryEntity roomCategoryEntity = session.get(RoomCategoryEntity.class, categoryId);
        return roomCategoryEntity;
    }

    @Override
    public void updateRoomCategory(RoomCategoryEntity roomCategoryEntity, Session session) throws Exception {
        session.update(roomCategoryEntity);
    }

    @Override
    public void deleteRoomCategory(RoomCategoryEntity roomCategoryEntity, Session session) throws Exception {
        session.delete(roomCategoryEntity);
    }

    @Override
    public List<RoomCategoryEntity> getAllRoomCategories(Session session) throws Exception {
        String hql = "FROM RoomCategoryEntity";
        Query<RoomCategoryEntity> query = session.createQuery(hql);
        List<RoomCategoryEntity> roomCategoryEntities = query.list();
        return roomCategoryEntities;
    }

}
