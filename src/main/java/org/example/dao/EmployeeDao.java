package org.example.dao;

import org.example.Model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    Employee getEmployeeByID(int empID);

    void addEmployee(Employee employee);

    void deleteEmployee(int empID);
}
