package com.interview.ibm.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class EmployeeDTO extends BaseDTO{

private UUID id;
private String name;
private EmployeeRole role;

    public UUID getId() {
        return id;
    }

    public EmployeeDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeDTO setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public EmployeeDTO setRole(EmployeeRole role) {
        this.role = role;
        return this;
    }
}
