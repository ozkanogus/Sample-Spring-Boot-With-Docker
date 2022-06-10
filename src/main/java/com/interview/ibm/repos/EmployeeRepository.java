package com.interview.ibm.repos;


import com.interview.ibm.domain.Employee;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface EmployeeRepository extends JpaRepository<Employee, UUID>,JpaSpecificationExecutor<Employee> {
	
	Page<Employee> findAll(Specification<Employee> spec , Pageable pageable);
	
}
