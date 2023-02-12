package org.example.Service;

import org.example.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "Remon", "Gopalganj", "0156656565611"));
        employeeList.add(new Employee(2, "Remon1", "Gopalganj1", "0156656565611"));
        employeeList.add(new Employee(3, "Remon2", "Gopalganj2", "0156656565611"));
        employeeList.add(new Employee(4, "Remon3", "Gopalganj3", "0156656565612"));
        return employeeList;
    }
}
