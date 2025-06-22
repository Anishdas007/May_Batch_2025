package com.ORM_JPA.class1.service;

import com.ORM_JPA.class1.dto.AddressDTO;
import com.ORM_JPA.class1.dto.DepartmentDTO;
import com.ORM_JPA.class1.dto.StudentDTO;
import com.ORM_JPA.class1.entity.Address;
import com.ORM_JPA.class1.entity.Department;
import com.ORM_JPA.class1.entity.Student;
import com.ORM_JPA.class1.repository.DepartmentRepository;
import com.ORM_JPA.class1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());

        Address address = new Address();
        address.setCity(studentDTO.getAddress().getCity());
        address.setState(studentDTO.getAddress().getState());
        address.setZipCode(studentDTO.getAddress().getZipCode());
        address.setStudent(student);
        student.setAddress(address);

        Department department = departmentRepository.findById(studentDTO.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        student.setDepartment(department);

        student = studentRepository.save(student);
        return mapToDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return mapToDTO(student);
    }

    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                new AddressDTO(
                        student.getAddress() != null ? student.getAddress().getCity() : null,
                        student.getAddress() != null ? student.getAddress().getState() : null,
                        student.getAddress() != null ? student.getAddress().getZipCode() : null),
                new DepartmentDTO(
                        student.getDepartment().getId(),
                        student.getDepartment().getName(),
                        null));
    }
}
