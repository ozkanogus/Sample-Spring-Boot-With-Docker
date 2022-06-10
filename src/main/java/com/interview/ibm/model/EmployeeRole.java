package com.interview.ibm.model;

public enum EmployeeRole {
    EMPLOYEE("Employee"),
    MANAGER("Manager"),
    DIRECTOR("Director");
    private String name;
    private EmployeeRole(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
