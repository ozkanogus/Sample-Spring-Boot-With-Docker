package com.interview.ibm.domain;

import com.interview.ibm.model.EmployeeRole;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Employee extends BaseEntity {
    @Id
    @Column(nullable = false, updatable = false, columnDefinition = "char(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    @GeneratedValue
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    public UUID getId() {
        return id;
    }

    public Employee setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public Employee setRole(EmployeeRole role) {
        this.role = role;
        return this;
    }
}
