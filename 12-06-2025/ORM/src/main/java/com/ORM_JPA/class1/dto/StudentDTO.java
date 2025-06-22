package com.ORM_JPA.class1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private AddressDTO address;
    private DepartmentDTO department;
    private List<CourseDTO> courses;

    public StudentDTO(Long id, String name, AddressDTO address, DepartmentDTO department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.department = department;
    }
}