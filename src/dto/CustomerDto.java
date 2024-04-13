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
public class CustomerDto {

    private Integer customerId;

    private String customerName;

    private String email;

    private String phoneNumber;

    private String address;

    public CustomerDto(String customerName, String email, String phoneNumber, String address) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
