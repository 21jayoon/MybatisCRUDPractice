package com.ohgiraffers.practices.model;

import java.util.Date;

public class PublisherDTO0524 {
    private String empId;
    private String empName;
    private String email;
    private String deptCode;
    private int salary;
    private Date hireDate;

    public PublisherDTO0524() {}

    public PublisherDTO0524(String empId, String empName, String email, String deptCode, int salary, Date hireDate) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.deptCode = deptCode;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "HeuimangEmp{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
