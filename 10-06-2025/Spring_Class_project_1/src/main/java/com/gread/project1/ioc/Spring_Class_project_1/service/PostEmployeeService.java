package com.gread.project1.ioc.Spring_Class_project_1.service;

import com.gread.project1.ioc.Spring_Class_project_1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PostEmployeeService {

    @Value("${spring.application.Id}")
    String apid;
    @Value("${spring.application-prod.Id}")
    String Id;

    public String createEmpl(Employee ep){
        System.out.println(apid);
        System.out.println(Id);
        System.out.println("PostEmpService called");
        System.out.println(ep.toString());
        return ep.toString();
    }
}
