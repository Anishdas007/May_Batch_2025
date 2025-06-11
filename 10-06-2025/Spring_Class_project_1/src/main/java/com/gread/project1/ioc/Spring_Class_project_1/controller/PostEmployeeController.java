package com.gread.project1.ioc.Spring_Class_project_1.controller;


import com.gread.project1.ioc.Spring_Class_project_1.model.Employee;
import com.gread.project1.ioc.Spring_Class_project_1.service.PostEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PostEmployeeController {

    @Autowired
    PostEmployeeService pes;


    @PostMapping("/emp")
    public String CreateEmp(@RequestBody Employee ep){
        System.out.println("post employee controller called");
       return pes.createEmpl(ep);
    }

}
