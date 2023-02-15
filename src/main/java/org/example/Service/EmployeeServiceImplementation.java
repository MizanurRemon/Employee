package org.example.Service;

import org.example.Model.CommonResponse;
import org.example.Model.Employee;
import org.example.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {


    @Autowired
    private EmployeeDao employeeDao;

    
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    
    @Override
    public Employee getEmployeeByID(int empID) {
        return employeeDao.getEmployeeByID(empID);
    }

    
    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);

    }


    @Override
    public void deleteEmployee(int empID) {
        employeeDao.deleteEmployee(empID);
    }
}
