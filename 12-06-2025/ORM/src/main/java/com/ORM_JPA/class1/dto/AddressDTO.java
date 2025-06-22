package com.ORM_JPA.class1.dto;

import com.ORM_JPA.class1.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public AddressDTO(String city, String state, String zipCode) {
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
