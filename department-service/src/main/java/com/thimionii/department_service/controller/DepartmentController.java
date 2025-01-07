package com.thimionii.department_service.controller;

import com.thimionii.department_service.client.EmployeeClient;
import com.thimionii.department_service.model.Department;
import com.thimionii.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class.getName());

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping()
    public Department add(@RequestBody Department department) {
        LOGGER.info("Inside add() of DepartmentController");
        LOGGER.info("Department added: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping()
    public List<Department> findAll() {
        LOGGER.info("Inside findAll() of DepartmentController");
        LOGGER.info("Department findAll:");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        LOGGER.info("Inside findById of DepartmentController");
        LOGGER.info("Department findById : {}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/name/{name}")
    public Department findByName(@PathVariable String name) {
        LOGGER.info("Inside findByName of DepartmentController");
        LOGGER.info("Department find by name :{}", name);
        return departmentRepository.findByName(name);
    }


    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department found with employees");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> {
            department.setEmployees(
                    employeeClient.findEmployeeByDepartment(
                            department.getId()));
        });
        return departments;
    }
}
