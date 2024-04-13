/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

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
public class RoomCategoryDto {

    private Integer categoryId;

    private String categoryName;

    private String description;

    private Double basePrice;

    public RoomCategoryDto(String categoryName, String description, Double basePrice) {
        this.categoryName = categoryName;
        this.description = description;
        this.basePrice = basePrice;
    }

}
