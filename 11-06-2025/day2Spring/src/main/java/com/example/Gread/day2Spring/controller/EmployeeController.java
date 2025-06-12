package com.example.Gread.day2Spring.controller;

import com.example.Gread.day2Spring.dto.EmployeeDto;
import com.example.Gread.day2Spring.model.Employee;
import com.example.Gread.day2Spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getemp")
    public ResponseEntity<Employee> getEmployee(@RequestParam long id){
        System.out.println("in the getEmployee Call");
        System.out.println("changes applied");
       return ResponseEntity.status(200).body(employeeService.getEmployee(id));
    }
    @DeleteMapping ("/user")
    public String userLogin(){
        return "User login succesfull hehe";
    }

}
