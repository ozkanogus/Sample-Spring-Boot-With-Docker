package com.interview.ibm.repos;

import static org.assertj.core.api.Assertions.assertThat;

import com.interview.ibm.domain.Employee;
import com.interview.ibm.model.EmployeeRole;
import com.interview.ibm.specification.EmployeeSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void pagingSpecificationDoesNotRequireAnUnmappedActiveAttribute() {
        repository.save(new Employee().setName("Ada Lovelace").setRole(EmployeeRole.EMPLOYEE));
        var filter = new Employee().setName("ada");

        var result = repository.findAll(new EmployeeSpecification(filter), PageRequest.of(0, 10));

        assertThat(result.getContent()).extracting(Employee::getName).containsExactly("Ada Lovelace");
    }
}
