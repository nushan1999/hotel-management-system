/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.custom;

import Service.SuperService;
import dto.RoomCategoryDto;
import java.util.List;

/**
 *
 * @author Nushan Vandabona
 */
public interface RoomCategoryService extends SuperService {

    String saveRoomCategory(RoomCategoryDto roomCategoryDto) throws Exception;

    String updateRoomCategory(RoomCategoryDto roomCategoryDto) throws Exception;

    String deleteRoomCategory(Integer categoryId) throws Exception;

    RoomCategoryDto getRoomCategory(Integer categoryId) throws Exception;

    List<RoomCategoryDto> getAll() throws Exception;

}
