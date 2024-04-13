/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entity.RoomEntity.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Nushan Vandabona
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomDto {

    private Integer roomId;

    private String roomNumber;

    private RoomStatus status;

    private Integer categoryId;

    public RoomDto(String roomNumber, RoomStatus status, Integer categoryId) {
        this.roomNumber = roomNumber;
        this.status = status;
        this.categoryId = categoryId;
    }

}
