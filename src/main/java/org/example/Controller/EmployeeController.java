package org.example.Controller;

import org.example.Handler.Exception.ApiRequestException;
import org.example.Model.CommonResponse;
import org.example.Model.Employee;
import org.example.Model.GetAllResponse;
import org.example.Model.GetEmployeeData;
import org.example.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

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
    public ResponseEntity<?> getAllEmployees() {


        if (employeeService.getAllEmployees() == null) {
            throw new ApiRequestException("No record found");
        } else {
            GetAllResponse response = new GetAllResponse();
            response.statusCode = HttpStatus.OK.value();
            response.data = employeeService.getAllEmployees();
            return ResponseEntity.ok(response);
        }

    }


    @PostMapping("/getEmployeeByID")
    public ResponseEntity<?> getEmployeeByID(String empID) {
        //return employeeService.getEmployeeByID(empID);
//        Employee employee = new Employee();
//        employee = employeeService.getEmployeeByID(empID);
//        if (TextUt) {
//        } else {
//        }
//        throw new ApiRequestException("ffffff exception");

        if (empID.isEmpty()) {
            throw new ApiRequestException("Invalid employee ID");
        } else {
            try {
                Employee response = employeeService.getEmployeeByID(Integer.parseInt(empID));

                if (response != null) {
                    GetEmployeeData commonResponse = new GetEmployeeData();
                    commonResponse.statusCode = HttpStatus.OK.value();
                    commonResponse.employee = response;
                    return ResponseEntity.ok(commonResponse);
                } else {
                    throw new ApiRequestException("No record found");
                }
            } catch (Exception e) {
                throw new ApiRequestException("Invalid employee ID");
            }

        }


    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(Employee employee) {

        if (employee.getName().isEmpty() || employee.getPhone().isEmpty() || employee.getAddress().isEmpty()) {
            String value = "";

            if (employee.getName().isEmpty()) {
                value = "name";
            } else if (employee.getPhone().isEmpty()) {
                value = "phone";
            } else if (employee.getAddress().isEmpty()) {
                value = "address";
            }
            throw new ApiRequestException(value + " empty");

        } else {
            CommonResponse response = new CommonResponse();

            response.statusCode = HttpStatus.OK.value();

            try {
                if(employeeService.addEmployee(employee)){
                    response.message = "successfully added";
                }else {
                    response.message = "not added";
                }
                return ResponseEntity.ok(response);
            }catch (Exception e){
                throw new ApiRequestException(e.getMessage());
            }
        }


    }

    @PostMapping("/deleteEmployee")
    public ResponseEntity<?> deleteEmployee(String empID) {


        if (empID.isEmpty()) {
            throw new ApiRequestException("Invalid employee ID");

        } else {
            CommonResponse response = new CommonResponse();
            employeeService.deleteEmployee(Integer.parseInt(empID));
            response.statusCode = HttpStatus.OK.value();
            response.message = "successfully deleted";
            return ResponseEntity.ok(response);
        }

        //response.message = empID;


    }

    @PostMapping("/getAllEmployeesByPlace")
    public ResponseEntity<?> getAllEmployees(String place) {


        if (employeeService.getAllEmployeesByPlace(place) == null) {
            throw new ApiRequestException("No record found");
        } else {
            GetAllResponse response = new GetAllResponse();
            response.statusCode = HttpStatus.OK.value();
            response.data = employeeService.getAllEmployeesByPlace(place);
            return ResponseEntity.ok(response);
        }

    }


    @PostMapping("/updateEmployee")
    public ResponseEntity<?> updateEmployee(Employee employee) {
        try {
            if (employee.getName().isEmpty() || employee.getPhone().isEmpty() || employee.getAddress().isEmpty() || String.valueOf(employee.getEmpID()).isEmpty()) {
                String value = "";
                if (employee.getName().isEmpty()) {
                    value = "name";
                } else if (employee.getPhone().isEmpty()) {
                    value = "phone";
                } else if (employee.getAddress().isEmpty()) {
                    value = "address";
                } else if (employee.getEmpID() == 0) {
                    value = "empID";
                }
                throw new ApiRequestException(value + " empty");

            } else {
                CommonResponse response = new CommonResponse();
                response.statusCode = HttpStatus.OK.value();
                if (employeeService.updateEmployee(employee)) {
                    response.message = "employee update completed";
                } else {
                    response.message = "employee update failed";
                }

                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }


    }
}
