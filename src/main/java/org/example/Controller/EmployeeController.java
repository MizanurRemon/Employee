package org.example.Controller;

import org.example.Model.Employee;
import org.example.Model.CommonResponse;
import org.example.Service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired //for mapping instead of creating objects
    EmployeeServiceImplementation employeeServiceImplementation;

    @RequestMapping("/")
    public CommonResponse test() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.message = "server running";
        return commonResponse;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeServiceImplementation.getAllEmployees();

    }


    @RequestMapping("/getEmployeeByID")
    public Employee getEmployeeByID(@RequestParam(value = "empID", defaultValue = "null") int empID) {
        return employeeServiceImplementation.getEmployeeByID(empID);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/addEmployee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeServiceImplementation.addEmployee(employee);
    }
}
