package org.example.Service;

import org.example.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeByID(int empID);

    boolean addEmployee(Employee employee);

    void deleteEmployee(int empID);

    List<Employee> getAllEmployeesByPlace(String place);

    boolean updateEmployee(Employee employee);
}
