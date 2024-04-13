/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.custom.impl;

import Service.custom.RoomCategoryService;
import dto.RoomCategoryDto;
import entity.RoomCategoryEntity;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.RepositoryFactory;
import repository.custom.RoomCategoryRepository;
import util.SessionFactoryConfiguration;

/**
 *
 * @author Nushan Vandabona
 */
public class RoomCategoryServiceImpl implements RoomCategoryService {

    private RoomCategoryRepository roomCategoryRepository = (RoomCategoryRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ROOMCATEGORY);

    @Override
    public String saveRoomCategory(RoomCategoryDto roomCategoryDto) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            RoomCategoryEntity roomCategoryEntity = new RoomCategoryEntity();
            roomCategoryEntity.setCategoryName(roomCategoryDto.getCategoryName());
            roomCategoryEntity.setDescription(roomCategoryDto.getDescription());
            roomCategoryEntity.setBasePrice(roomCategoryDto.getBasePrice());
            Integer roomCategoryId = roomCategoryRepository.saveRoomCategory(roomCategoryEntity, session);
            if (roomCategoryId != null) {
                transaction.commit();
                return "Room Category Saved Successfully";
            } else {
                transaction.rollback();
                return "Room Category Save Error";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String updateRoomCategory(RoomCategoryDto roomCategoryDto) throws Exception {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            RoomCategoryEntity roomCategoryEntity = roomCategoryRepository.getRoomCategory(roomCategoryDto.getCategoryId(), session);
            if (roomCategoryEntity == null) {
                transaction.rollback();
                return "Room Category Not Found";
            } else {
                roomCategoryEntity.setCategoryName(roomCategoryDto.getCategoryName());
                roomCategoryEntity.setDescription(roomCategoryDto.getDescription());
                roomCategoryEntity.setBasePrice(roomCategoryDto.getBasePrice());
                roomCategoryRepository.updateRoomCategory(roomCategoryEntity, session);
                transaction.commit();
                return "Room Category Updated Successfully";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String deleteRoomCategory(Integer categoryId) throws Exception {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            RoomCategoryEntity roomCategoryEntity = roomCategoryRepository.getRoomCategory(categoryId, session);
            if (roomCategoryEntity == null) {
                transaction.rollback();
                return "Room Category Not Found";
            } else {
                roomCategoryRepository.deleteRoomCategory(roomCategoryEntity, session);
                transaction.commit();
                return "Room Category Deleted Successfully";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public RoomCategoryDto getRoomCategory(Integer categoryId) throws Exception {

        Session session = null;

        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            RoomCategoryEntity roomCategoryEntity = roomCategoryRepository.getRoomCategory(categoryId, session);
            if (roomCategoryEntity != null) {
                RoomCategoryDto roomCategoryDto = new RoomCategoryDto(
                        roomCategoryEntity.getCategoryName(),
                        roomCategoryEntity.getDescription(),
                        roomCategoryEntity.getBasePrice());
                roomCategoryDto.setCategoryId(roomCategoryEntity.getCategoryId());
                return roomCategoryDto;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<RoomCategoryDto> getAll() throws Exception {

        Session session = null;
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            List<RoomCategoryEntity> roomCategoryEntities = roomCategoryRepository.getAllRoomCategories(session);
            List<RoomCategoryDto> roomCategoryDtos = new ArrayList<>();
            for (RoomCategoryEntity entity : roomCategoryEntities) {
                RoomCategoryDto dto = new RoomCategoryDto(
                        entity.getCategoryId(),
                        entity.getCategoryName(),
                        entity.getDescription(),
                        entity.getBasePrice());
                roomCategoryDtos.add(dto);
            }
            return roomCategoryDtos;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
