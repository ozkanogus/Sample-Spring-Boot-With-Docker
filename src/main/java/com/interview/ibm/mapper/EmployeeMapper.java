package com.interview.ibm.mapper;


import com.interview.ibm.domain.Employee;
import com.interview.ibm.model.EmployeeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface EmployeeMapper {
    EmployeeDTO employeeToEmployeeDTO(Employee employee);
    Employee employeeDTOToEmployee( EmployeeDTO employeeDTO);  
}

