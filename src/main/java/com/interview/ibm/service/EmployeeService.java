package com.interview.ibm.service;


import com.interview.ibm.domain.Employee;
import com.interview.ibm.mapper.EmployeeMapper;
import com.interview.ibm.model.EmployeeDTO;
import com.interview.ibm.model.ModelPaging;
import com.interview.ibm.repos.EmployeeRepository;
import com.interview.ibm.specification.EmployeeSpecification;
import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	private  EmployeeMapper mapper;

	public EmployeeService(final EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<EmployeeDTO> findAll() {
		return employeeRepository.findAll().stream().map(employee -> mapToDTO(employee)).collect(Collectors.toList());
	}

	public ModelPaging<EmployeeDTO> paging(@Valid Employee employee) {

		EmployeeSpecification spec = new EmployeeSpecification(employee);
		Pageable pagable = PageRequest.of(employee.getFirstResult(), employee.getMaxResults());

		if (employee.getSortOrder() != null && !employee.getSortOrder().isEmpty())
			pagable = PageRequest.of(employee.getFirstResult(), employee.getMaxResults(),
					employee.getSortOrder().equals("descend") ? Sort.by(employee.getSortField()).descending()
							: Sort.by(employee.getSortField()).ascending());
		Page<Employee> result = employeeRepository.findAll(spec, pagable);
		ModelPaging<EmployeeDTO> modelPaging = new ModelPaging<EmployeeDTO>();
		modelPaging.setTotalRecords(result.getTotalElements());
		modelPaging.setData(result.getContent().stream().map(p -> mapToDTO(p)).collect(Collectors.toList()));
		return modelPaging;
	}

	public EmployeeDTO get(final UUID id) {
		return employeeRepository.findById(id).map(employee -> mapToDTO(employee))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public UUID create(final EmployeeDTO employeeDTO) {

		final Employee employee = mapToEntity(employeeDTO);
		employee.getId();
		return employeeRepository.save(employee).getId();
	}

	public void update(final UUID id, EmployeeDTO employeeDTO) {

		Employee oldEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		oldEmployee = mapToEntity(employeeDTO);
		employeeRepository.save(oldEmployee);
	}

	public void delete(final UUID id) {
		Employee oldEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		employeeRepository.delete(oldEmployee);
	}



	private EmployeeDTO mapToDTO(final Employee employee) {
		return mapper.employeeToEmployeeDTO(employee);
	}

	private Employee mapToEntity(final EmployeeDTO employeeDTO) {
		return mapper.employeeDTOToEmployee(employeeDTO);
	}

}
