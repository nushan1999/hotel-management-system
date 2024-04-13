/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.custom;

import Service.SuperService;
import dto.RoomDto;
import java.util.List;

/**
 *
 * @author Nushan Vandabona
 */
public interface RoomService extends SuperService {

    String saveRoom(RoomDto roomDto) throws Exception;

    String updateRoom(RoomDto roomDto) throws Exception;

    String deleteRoom(Integer roomId) throws Exception;

    RoomDto getRoom(Integer roomId) throws Exception;

    List<RoomDto> getAll() throws Exception;

}
