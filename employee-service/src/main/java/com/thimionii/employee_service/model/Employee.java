package com.thimionii.employee_service.model;

public record Employee(
        Long id,
        Long departmentId,
        String name,
        Integer  age,
        String position
) {

}
