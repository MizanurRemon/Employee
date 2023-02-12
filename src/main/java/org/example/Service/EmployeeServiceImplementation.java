package org.example.Service;

import org.example.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "Remon", "Gopalganj", "0156656565611"),
            new Employee(2, "Remon1", "Gopalganj1", "0156656565612"),
            new Employee(2, "Remon1", "Gopalganj2", "0156656565613")
    ));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeByID(int empID) {

        return employeeList.stream().filter(e -> e.getEmpID() == empID).findFirst().get();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
