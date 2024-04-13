/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.custom;

import entity.RoomCategoryEntity;
import java.util.List;
import org.hibernate.Session;
import repository.SuperRepository;

/**
 *
 * @author Nushan Vandabona
 */
public interface RoomCategoryRepository extends SuperRepository {

    Integer saveRoomCategory(RoomCategoryEntity roomCategoryEntity, Session session) throws Exception;

    RoomCategoryEntity getRoomCategory(Integer categoryId, Session session) throws Exception;

    void updateRoomCategory(RoomCategoryEntity roomCategoryEntity, Session session) throws Exception;

    void deleteRoomCategory(RoomCategoryEntity roomCategoryEntity, Session session) throws Exception;

    List<RoomCategoryEntity> getAllRoomCategories(Session session) throws Exception;
}
