/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Service.ServiceFactory;
import Service.custom.RoomCategoryService;
import dto.RoomCategoryDto;
import java.util.List;

/**
 *
 * @author Nushan Vandabona
 */
public class RoomCategoryController {

    private RoomCategoryService roomCategoryService = (RoomCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOMCATEGORY);

    public String saveRoomCategory(RoomCategoryDto roomCategoryDto) throws Exception {
        return roomCategoryService.saveRoomCategory(roomCategoryDto);
    }

    public String updateRoomCategory(RoomCategoryDto roomCategoryDto) throws Exception {
        return roomCategoryService.updateRoomCategory(roomCategoryDto);
    }

    public String deleteRoomCategory(Integer categoryId) throws Exception {
        return roomCategoryService.deleteRoomCategory(categoryId);
    }

    public RoomCategoryDto getRoomCategory(Integer categoryId) throws Exception {
        return roomCategoryService.getRoomCategory(categoryId);
    }

    public List<RoomCategoryDto> getAll() throws Exception {
        return roomCategoryService.getAll();
    }

}
