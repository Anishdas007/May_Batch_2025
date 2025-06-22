package com.ORM_JPA.class1.service;

import com.ORM_JPA.class1.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);
}
