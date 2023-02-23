package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.Handler.Exception.ApiRequestException;
import org.example.Model.Employee;
import org.example.Utils.Constants;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbc);
        this.jdbcTemplate = new JdbcTemplate(jdbc);
    }

    @Autowired(required = true)
    private EntityManager entityManager;


    @Override
    public List<Employee> getAllEmployees() {
//        Session currentSession = entityManager.unwrap(Session.class);
//        String sqlQuery = "FROM tbl_employee";
//        Query<Employee> query = currentSession.createQuery(sqlQuery, Employee.class);
//        return query.getResultList();

        String sqlQuery = "SELECT * FROM tbl_employee ORDER BY empID DESC";
        try {
            return jdbcTemplate.query(sqlQuery, new RowMapper<Employee>() {
                @Override
                public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Employee employee = new Employee();
                    employee.setEmpID(rs.getInt(Constants.EMPLOYEE_ID));
                    employee.setName(rs.getString(Constants.NAME));
                    employee.setAddress(rs.getString(Constants.ADDRESS));
                    employee.setPhone(rs.getString(Constants.PHONE));
                    employee.setDate(rs.getDate(Constants.DATE));
                    return employee;
                }
            });
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }

    }


    @Override
    public List<Employee> getAllEmployeesByPlace(String place) {

        String sqlQuery = "SELECT * FROM tbl_employee where address=" + "'" + place + "'"+" ORDER BY empID DESC";
        return namedParameterJdbcTemplate.query(sqlQuery, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

                Employee employee = new Employee();
                employee.setEmpID(rs.getInt(Constants.EMPLOYEE_ID));
                employee.setName(rs.getString(Constants.NAME));
                employee.setAddress(rs.getString(Constants.ADDRESS));
                employee.setPhone(rs.getString(Constants.PHONE));
                employee.setDate(rs.getDate(Constants.DATE));
                return employee;
            }
        });

    }

    @Override
    public Employee getEmployeeByID(int empID) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", empID);

        String sqlQuery = "SELECT * FROM tbl_employee where empID= :id";
        return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

                Employee employee = new Employee();
                employee.setEmpID(rs.getInt(Constants.EMPLOYEE_ID));
                employee.setName(rs.getString(Constants.NAME));
                employee.setAddress(rs.getString(Constants.ADDRESS));
                employee.setPhone(rs.getString(Constants.PHONE));
                employee.setDate(rs.getDate(Constants.DATE));
                return employee;
            }
        });
    }

    @Override
    public boolean addEmployee(Employee employee) {
//        Session currentSession = entityManager.unwrap(Session.class);
//        currentSession.save(employee);

        String sqlQuery = "INSERT into " + Constants.TBL_EMPLOYEE + " (name, address, phone) values(?,?,?)";

        return jdbcTemplate.update(
                sqlQuery,
                employee.getName(),
                employee.getAddress(),
                employee.getPhone()
        ) == 1;
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

    @Override
    public boolean updateEmployee(Employee employee) {

       /* MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", employee.getEmpID());
        params.addValue("name", employee.getName());
        params.addValue("address", employee.getAddress());
        params.addValue("phone", employee.getPhone());*/


        String query = "UPDATE " + Constants.TBL_EMPLOYEE + " SET name = ?,address =?, phone=? WHERE empID = ?";

        try {
            return jdbcTemplate.update(
                    query,
                    employee.getName(),
                    employee.getAddress(),
                    employee.getPhone(),
                    employee.getEmpID()
            ) == 1;
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
        //return true
    }


}
