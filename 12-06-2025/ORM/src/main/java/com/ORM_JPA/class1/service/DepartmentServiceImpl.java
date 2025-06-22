package com.ORM_JPA.class1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ORM_JPA.class1.dto.DepartmentDTO;
import com.ORM_JPA.class1.entity.Department;
import com.ORM_JPA.class1.repositary.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDTO fromEntity(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(department.getId());
        departmentDTO.setName(department.getDepartmentName());
        return departmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = DepartmentRepository.findById(id).orElse(null);
        if (department == null) {
            throw new RuntimeException("Department not found");
        }
        return fromEntity(department);
    }
}
