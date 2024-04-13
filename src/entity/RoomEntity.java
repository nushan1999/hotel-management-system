/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Nushan Vandabona
 */
@Entity
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomEntity {
    
    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    
    @Column(name = "room_number", nullable = false, length = 100, unique = true)
    private String roomNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RoomStatus status;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private RoomCategoryEntity category;
    
    @OneToMany(mappedBy = "room", targetEntity = ReservationEntity.class)
    @Transient
    private List<ReservationEntity> reservationEntities = new ArrayList<>();
    
    //Enum for Room Status
    public enum RoomStatus{
        AVAILABLE, MAINTENANCE, UNAVAILABLE
    }
    
}
