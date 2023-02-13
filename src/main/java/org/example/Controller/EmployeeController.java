package org.example.Controller;

import org.example.Model.CommonResponse;
import org.example.Model.Employee;
import org.example.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

//    @Autowired //for mapping instead of creating objects
//    EmployeeServiceImplementation employeeServiceImplementation;
//
//    @RequestMapping("/")
//    public CommonResponse test() {
//        CommonResponse commonResponse = new CommonResponse();
//        commonResponse.message = "server running";
//        return commonResponse;
//    }
//
//
//    @RequestMapping(method = RequestMethod.POST, value = "/getAllEmployees")
//    public List<Employee> getAllEmployees() {
//        return employeeServiceImplementation.getAllEmployees();
//
//    }
//
//
//    @RequestMapping("/getEmployeeByID")
//    public Employee getEmployeeByID(@RequestParam(value = "empID", defaultValue = "null") int empID) {
//        return employeeServiceImplementation.getEmployeeByID(empID);
//
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/addEmployee")
//    public CommonResponse addEmployee(@RequestBody Employee employee) {
//
//        employeeServiceImplementation.addEmployee(employee);
//
//        CommonResponse commonResponse = new CommonResponse();
//        commonResponse.message = "successfully added";
//
//        return commonResponse;
//    }

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public CommonResponse welcome() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.message = "server running";
        return commonResponse;
    }

    @PostMapping("/test")
    public CommonResponse test() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.message = "test successful";
        return commonResponse;
    }

    @PostMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }


    @PostMapping("/getEmployeeByID")
    public Employee getEmployeeByID(int empID) {
        return employeeService.getEmployeeByID(empID);

    }

    @PostMapping("/addEmployee")
    public CommonResponse addEmployee(Employee employee) {
        employeeService.addEmployee(employee);

        System.out.println(employee.toString());

        CommonResponse response = new CommonResponse();
        response.message = "successfully added";

        return response;
    }

    @PostMapping("/deleteEmployee")
    public CommonResponse addEmployee(int empID) {
        employeeService.deleteEmployee(empID);

        CommonResponse response = new CommonResponse();
        response.message = "successfully deleted";

        return response;
    }
}
