package org.example.Controller;

import org.example.Model.Employee;
import org.example.Service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired //for mapping instead of creating objects
    EmployeeServiceImplementation employeeServiceImplementation;

    @RequestMapping("/")
    public String test() {
        return "server testing";
    }


    @RequestMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeServiceImplementation.getAllEmployees();

    }
}
