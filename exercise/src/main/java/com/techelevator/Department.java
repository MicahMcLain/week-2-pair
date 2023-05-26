package com.techelevator;

public class Department {
    String name;
    int departmentId;

    public Department(String name, int departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
