package org.example.Model;


import jakarta.persistence.*;

@Entity(name = "tbl_salary")
@Table(name = "tbl_salary")
public class Salary {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "empID")
    private int empID;

    @Column(name = "salary")
    private int salary;

    public Salary() {
    }

    public Salary(int id, int empID, int salary) {
        this.id = id;
        this.empID = empID;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
