package com.interview.ibm.domain;

import com.interview.ibm.model.EmployeeRole;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Employee extends BaseEntity {
    @Id
    @Column(nullable = false, updatable = false, columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    private UUID id;

    private String name;

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
