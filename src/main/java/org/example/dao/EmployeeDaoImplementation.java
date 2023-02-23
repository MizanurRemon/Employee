package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.Handler.Exception.ApiRequestException;
import org.example.Model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
public class EmployeeDaoImplementation implements EmployeeDao {


    @Autowired(required = true)
    private EntityManager entityManager;


    @Override
    public List<Employee> getAllEmployees() {
        Session currentSession = entityManager.unwrap(Session.class);
        String sqlQuery = "FROM tbl_employee";
        Query<Employee> query = currentSession.createQuery(sqlQuery, Employee.class);
        return query.getResultList();

    }


    @Override
    public List<Employee> getAllEmployeesByPlace(String place) {
        Session currentSession = entityManager.unwrap(Session.class);
        String sqlQuery = "SELECT e FROM tbl_employee e where e.address = :place";
        Query<Employee> query = currentSession.createQuery(sqlQuery, Employee.class);
        query.setParameter("place", place);
        return query.getResultList();

        //return Collections.singletonList(currentSession.get(Employee.class, place));


    }

    @Override
    public Employee getEmployeeByID(int empID) {

        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, empID);
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(employee);
    }

    @Override
    public void deleteEmployee(int empID) {
        Session currenSession = entityManager.unwrap(Session.class);
        Employee employee = currenSession.get(Employee.class, empID);

        if (employee != null) {
            currenSession.delete(employee);
        } else {
            throw new ApiRequestException("No record found");
        }
    }
}
