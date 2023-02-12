package org.example.Model;

public class Employee {
    private int empID;
    private String name;
    private String address;
    private String phone;

    public Employee(int empID, String name, String address, String phone) {
        this.empID = empID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
