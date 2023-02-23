package org.example.dao;

import org.example.Model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    List<Employee> getAllEmployeesByPlace(String place);

    Employee getEmployeeByID(int empID);


    boolean addEmployee(Employee employee);

    void deleteEmployee(int empID);

    boolean updateEmployee(Employee employee);
}
