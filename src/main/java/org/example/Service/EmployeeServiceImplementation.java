package org.example.Service;

import org.example.Model.CommonResponse;
import org.example.Model.Employee;
import org.example.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

//    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
//            new Employee(1, "Remon", "Gopalganj", "0156656565611"),
//            new Employee(2, "Remon1", "Gopalganj1", "0156656565612"),
//            new Employee(2, "Remon1", "Gopalganj2", "0156656565613")
//    ));
//
//    @Override
//    public List<Employee> getAllEmployees() {
//        return employeeList;
//    }
//
//    @Override
//    public Employee getEmployeeByID(int empID) {
//
//        return employeeList.stream().filter(e -> e.getEmpID() == empID).findFirst().get();
//    }
//
//    @Override
//    public void addEmployee(Employee employee) {
//        employeeList.add(employee);
//    }

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    @Override
    public Employee getEmployeeByID(int empID) {
        return employeeDao.getEmployeeByID(empID);
    }

    @Transactional
    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);

    }

    @Transactional
    @Override
    public void deleteEmployee(int empID) {
        employeeDao.deleteEmployee(empID);
    }
}
