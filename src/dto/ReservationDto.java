/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entity.ReservationEntity.PackageType;
import entity.ReservationEntity.ReservationStatus;
import java.util.Date;
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
public class ReservationDto {

    private Integer reservationId;

    private Date checkInDate;

    private Date checkOutDate;
    
    private Date placedAt;

    private Double totalPrice;

    private Integer customerId;

    private Integer roomId;

    private PackageType packageType;

    private ReservationStatus status;

    public ReservationDto(Date checkInDate, Date checkOutDate, Date placedAt, Double totalPrice, Integer customerId, Integer roomId, PackageType packageType, ReservationStatus status) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.placedAt = placedAt;
        this.totalPrice = totalPrice;
        this.customerId = customerId;
        this.roomId = roomId;
        this.packageType = packageType;
        this.status = status;
    }
    
    public ReservationDto(Date checkInDate, Date checkOutDate, Date placedAt, Integer customerId, Integer roomId, PackageType packageType) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.placedAt = placedAt;
        this.customerId = customerId;
        this.roomId = roomId;
        this.packageType = packageType;
    }
}
