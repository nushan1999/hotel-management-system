/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Service.ServiceFactory;
import Service.custom.RoomService;
import dto.RoomDto;
import java.util.List;

/**
 *
 * @author Nushan Vandabona
 */
public class RoomController {
    
    private RoomService roomService = (RoomService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOM);

    public String saveRoom(RoomDto roomDto) throws Exception {
        return roomService.saveRoom(roomDto);
    }
    
    public String updateRoom(RoomDto roomDto) throws Exception {
        return roomService.updateRoom(roomDto);
    }
    
    public String deleteRoom(Integer roomId) throws Exception {
        return roomService.deleteRoom(roomId);
    }
    
    public RoomDto getRoom(Integer roomId) throws Exception {
        return roomService.getRoom(roomId);
    }
    
    public List<RoomDto> getAll() throws Exception {
        return roomService.getAll();
    }
}
