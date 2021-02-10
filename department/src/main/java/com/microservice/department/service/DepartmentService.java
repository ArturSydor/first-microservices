package com.microservice.department.service;

import com.microservice.department.entity.Department;

public interface DepartmentService {

    Department createDepartment(Department newDepartment);

    Department getById(Long id);

}
