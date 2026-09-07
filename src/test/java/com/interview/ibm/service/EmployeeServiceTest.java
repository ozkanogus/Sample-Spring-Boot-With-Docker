package com.interview.ibm.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.interview.ibm.domain.Employee;
import com.interview.ibm.mapper.EmployeeMapper;
import com.interview.ibm.model.EmployeeDTO;
import com.interview.ibm.model.EmployeeRole;
import com.interview.ibm.repos.EmployeeRepository;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @Mock
    private EmployeeMapper mapper;

    private EmployeeService service;

    @BeforeEach
    void setUp() {
        service = new EmployeeService(repository, mapper);
    }

    @Test
    void createsAndReturnsGeneratedIdentifier() {
        var dto = employeeDto("Ada");
        var employee = new Employee().setName("Ada").setRole(EmployeeRole.EMPLOYEE);
        var generatedId = UUID.randomUUID();
        var saved = new Employee().setId(generatedId).setName("Ada").setRole(EmployeeRole.EMPLOYEE);
        when(mapper.employeeDTOToEmployee(dto)).thenReturn(employee);
        when(repository.save(employee)).thenReturn(saved);

        assertThat(service.create(dto)).isEqualTo(generatedId);
    }

    @Test
    void updateUsesPathIdentifierInsteadOfPayloadIdentifier() {
        var pathId = UUID.randomUUID();
        var dto = employeeDto("Grace").setId(UUID.randomUUID());
        var existing = new Employee().setId(pathId);
        var replacement = new Employee().setId(dto.getId()).setName("Grace");
        when(repository.findById(pathId)).thenReturn(Optional.of(existing));
        when(mapper.employeeDTOToEmployee(dto)).thenReturn(replacement);

        service.update(pathId, dto);

        assertThat(replacement.getId()).isEqualTo(pathId);
        verify(repository).save(replacement);
    }

    @Test
    void getReportsMissingEmployee() {
        var id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.get(id))
                .isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("404");
    }

    private static EmployeeDTO employeeDto(String name) {
        return new EmployeeDTO().setName(name).setRole(EmployeeRole.EMPLOYEE);
    }
}
