/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.custom.impl;

import Service.custom.RoomService;
import dto.RoomDto;
import entity.RoomCategoryEntity;
import entity.RoomEntity;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.RepositoryFactory;
import repository.custom.RoomCategoryRepository;
import repository.custom.RoomRepository;
import util.SessionFactoryConfiguration;

/**
 *
 * @author Nushan Vandabona
 */
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository = (RoomRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ROOM);
    private RoomCategoryRepository roomCategoryRepository = (RoomCategoryRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ROOMCATEGORY);

    @Override
    public String saveRoom(RoomDto roomDto) throws Exception {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            RoomCategoryEntity roomCategoryEntity = roomCategoryRepository.getRoomCategory(roomDto.getCategoryId(), session);
            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setRoomNumber(roomDto.getRoomNumber());
            roomEntity.setCategory(roomCategoryEntity);
            roomEntity.setStatus(roomDto.getStatus());
            Integer roomId = roomRepository.saveRoom(roomEntity, session);
            if (roomId != null) {
                transaction.commit();
                return "Room Saved Successfully";
            } else {
                transaction.rollback();
                return "Room Save Error";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String updateRoom(RoomDto roomDto) throws Exception {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            RoomEntity roomEntity = roomRepository.getRoom(roomDto.getRoomId(), session);
            if (roomEntity == null) {
                transaction.rollback();
                return "Room Not Found";
            } else {
                RoomCategoryEntity roomCategoryEntity = roomCategoryRepository.getRoomCategory(roomDto.getCategoryId(), session);
                roomEntity.setRoomNumber(roomDto.getRoomNumber());
                roomEntity.setCategory(roomCategoryEntity);
                roomEntity.setStatus(roomDto.getStatus());
                roomRepository.updateRoom(roomEntity, session);
                transaction.commit();
                return "Room Updated Successfully";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String deleteRoom(Integer roomId) throws Exception {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            RoomEntity roomEntity = roomRepository.getRoom(roomId, session);
            if (roomEntity == null) {
                transaction.rollback();
                return "Room Not Found";
            } else {
                roomRepository.deleteRoom(roomEntity, session);
                transaction.commit();
                return "Room Deleted Successfully";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public RoomDto getRoom(Integer roomId) throws Exception {
        Session session = null;

        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            RoomEntity roomEntity = roomRepository.getRoom(roomId, session);
            if (roomEntity != null) {
                RoomDto roomDto = new RoomDto(
                        roomEntity.getRoomNumber(),
                        roomEntity.getStatus(),
                        roomEntity.getCategory().getCategoryId());
                roomDto.setRoomId(roomEntity.getRoomId());
                return roomDto;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<RoomDto> getAll() throws Exception {
        Session session = null;
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            List<RoomEntity> roomEntities = roomRepository.getAllRooms(session);
            List<RoomDto> roomDtos = new ArrayList<>();
            for (RoomEntity entity : roomEntities) {
                RoomDto dto = new RoomDto(
                        entity.getRoomId(),
                        entity.getRoomNumber(),
                        entity.getStatus(),
                        entity.getCategory().getCategoryId());
                roomDtos.add(dto);
            }
            return roomDtos;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
