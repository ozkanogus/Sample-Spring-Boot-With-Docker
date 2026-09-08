package com.interview.ibm.specification;


import com.interview.ibm.domain.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;


@SuppressWarnings("serial")
public class EmployeeSpecification implements Specification<Employee> {
	Employee employee;

	public EmployeeSpecification(Employee employee) {
		this.employee = employee;
	}

	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate result = criteriaBuilder.conjunction();
	
		if (employee.getName() != null && !employee.getName().isEmpty()) {

			 Predicate r2 = criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
		 			"%" + employee.getName().toLowerCase() + "%"));
		 	result = result != null ? criteriaBuilder.and(r2, result) : r2;
		 }


		if (employee.getLastUpdateDateStart() != null && employee.getLastUpdateDateEnd() != null) {
			Predicate  r2 = criteriaBuilder.between(root.get("lastUpdated"), employee.getLastUpdateDateStart(),
					employee.getLastUpdateDateEnd());
			result = result != null ? criteriaBuilder.and(r2, result) : r2;
		}

		query.distinct(true);
		
		return result;
	}
}
