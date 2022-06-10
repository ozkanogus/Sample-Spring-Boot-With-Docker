package com.interview.ibm.rest;


import com.interview.ibm.domain.Employee;
import com.interview.ibm.exceptions.DublicateRecordException;
import com.interview.ibm.model.EmployeeDTO;
import com.interview.ibm.model.ModelPaging;
import com.interview.ibm.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable final UUID id) {
        return ResponseEntity.ok(employeeService.get(id));
    }

    @PostMapping
    public ResponseEntity<UUID> createEmployee(@RequestBody @Valid final EmployeeDTO employeeDTO, HttpServletRequest req)
            throws DublicateRecordException {
        return new ResponseEntity<>(employeeService.create(employeeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable final UUID id, @RequestBody @Valid final EmployeeDTO employeeDTO,
                                               HttpServletRequest req) throws Exception {
        employeeService.update(id, employeeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable final UUID id, HttpServletRequest req) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/paging")
    public ResponseEntity<ModelPaging<EmployeeDTO>> paging(@RequestBody @Valid final Employee employee, HttpServletRequest req)
            throws Exception {
        return ResponseEntity.ok(employeeService.paging(employee));
    }


}
