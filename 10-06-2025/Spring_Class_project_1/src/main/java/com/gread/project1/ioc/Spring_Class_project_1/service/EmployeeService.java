package com.gread.project1.ioc.Spring_Class_project_1.service;

import com.gread.project1.ioc.Spring_Class_project_1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Configuration
public class EmployeeService {

    @Bean
    public Employee CreatEntry(){
        System.out.println("employee Service");
        return new Employee();
    }
}
