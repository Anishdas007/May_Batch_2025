package com.gread.project1.ioc.Spring_Class_project_1;

import com.gread.project1.ioc.Spring_Class_project_1.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringClassProject1Application {
	public static void main(String[] args) {
//		ConfigurableApplicationContext run = SpringApplication.run(SpringClassProject1Application.class, args);
//		EmployeeService employeeService = run.getBean(EmployeeService.class);
//		employeeService.CreatEntry();
		SpringApplication.run(SpringClassProject1Application.class, args);

	}

}
