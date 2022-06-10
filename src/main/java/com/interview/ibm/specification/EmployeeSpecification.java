package com.interview.ibm.specification;


import com.interview.ibm.domain.Employee;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;


@SuppressWarnings("serial")
public class EmployeeSpecification implements Specification<Employee> {
	Employee employee;

	public EmployeeSpecification(Employee employee) {
		this.employee = employee;
	}

	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate result = criteriaBuilder.and(criteriaBuilder.equal(root.get("active"), true));
	
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
