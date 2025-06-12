package com.example.Gread.day2Spring.service;

import com.example.Gread.day2Spring.dto.EmployeeDto;
import com.example.Gread.day2Spring.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> result = new ArrayList<>();
        for (Employee emp : employeeList) {
            result.add(new EmployeeDto(emp.getName()));
        }
        return result;
    }

    public ResponseEntity<EmployeeDto> addEmployee(Employee employee) {
        for(Employee emp:employeeList){
            String created=new String("Employee already exists");
            if(emp.getId().equals(employee.getId()))return ResponseEntity.status(400).body(new EmployeeDto(created));
        }
        employeeList.add(employee);
        return ResponseEntity.status(201).body(new EmployeeDto(employee.getName()));
    }
    public Employee getEmployee(long id){
        for(Employee emp:employeeList){
            if(emp.getId().equals(id))return emp;
        }
        return null;
    }
}