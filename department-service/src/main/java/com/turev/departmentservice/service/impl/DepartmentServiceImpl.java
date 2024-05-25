package com.turev.departmentservice.service.impl;

import com.turev.departmentservice.dto.DepartmentDto;
import com.turev.departmentservice.entity.Department;
import com.turev.departmentservice.exception.ResourceNotFoundException;
import com.turev.departmentservice.mapper.DepartmentMapper;
import com.turev.departmentservice.repository.DepartmentRepository;
import com.turev.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = departmentRepository.save(DepartmentMapper.INSTANCE.departmentDtoToDepartment(departmentDto));
        return DepartmentMapper.INSTANCE.departmentToDepartmentDto(department);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(()-> new ResourceNotFoundException("Deparment","departmentCode", departmentCode));
        return DepartmentMapper.INSTANCE.departmentToDepartmentDto(department);
    }

}
