package com.microservice.department.service.impl;

import com.microservice.department.entity.Department;
import com.microservice.department.repository.DepartmentRepository;
import com.microservice.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department newDepartment) {
        log.info("Save new department = [{}]", newDepartment);
        return departmentRepository.save(newDepartment);
    }

    @Override
    public Department getById(Long id) {
        log.info("Get department with id={}", id);
        return departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Department with id = [%s] not found", id)));
    }
}
