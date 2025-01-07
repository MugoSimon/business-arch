package com.thimionii.employee_service.controller;

import com.thimionii.employee_service.model.Employee;
import com.thimionii.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class.getName());

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        LOGGER.info("Inside add() of EmployeeController");
        LOGGER.info("Employee added: {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping()
    public List<Employee> findAll() {
        LOGGER.info("Inside findAll() of EmployeeController");
        LOGGER.info("Employee findAll:");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        LOGGER.info("Inside findById of EmployeeController");
        LOGGER.info("Employee find By Id : {}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartment(@PathVariable Long departmentId) {
        LOGGER.info("Inside findEmployeeByDepartment of EmployeeController");
        LOGGER.info("Employee find By Department : {}", departmentId);
        return employeeRepository.findEmployeeByDepartment(departmentId);
    }
}
