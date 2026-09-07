package com.interview.ibm.mapper;


import com.interview.ibm.domain.Employee;
import com.interview.ibm.model.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface EmployeeMapper {
    EmployeeDTO employeeToEmployeeDTO(Employee employee);
    @Mapping(target = "firstResult", ignore = true)
    @Mapping(target = "maxResults", ignore = true)
    @Mapping(target = "sortField", ignore = true)
    @Mapping(target = "sortOrder", ignore = true)
    @Mapping(target = "lastUpdateDateStart", ignore = true)
    @Mapping(target = "lastUpdateDateEnd", ignore = true)
    @Mapping(target = "filterDateStart", ignore = true)
    @Mapping(target = "filterDateEnd", ignore = true)
    Employee employeeDTOToEmployee( EmployeeDTO employeeDTO);  
}
