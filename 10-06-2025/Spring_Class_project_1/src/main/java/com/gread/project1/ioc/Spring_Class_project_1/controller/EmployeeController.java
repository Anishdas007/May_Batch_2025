package com.gread.project1.ioc.Spring_Class_project_1.controller;

import com.gread.project1.ioc.Spring_Class_project_1.model.Employee;
import com.gread.project1.ioc.Spring_Class_project_1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/employee")
//public class EmployeeController {
//    @Autowired
//    public EmployeeService employeeService;
//    @GetMapping("/dummy")
//    public String createemployee(){
//       return employeeService.CreatEntry();
//    }
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/dummy")
    public Employee getDummyEmployee() {
        Employee epm=employeeService.CreatEntry();
        epm.setName("Anish");
        epm.setId(1);
        System.out.println(epm);
        return epm;
    }
}

