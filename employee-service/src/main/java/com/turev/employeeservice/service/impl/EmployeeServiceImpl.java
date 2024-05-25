package com.turev.employeeservice.service.impl;

import com.turev.employeeservice.dto.EmployeeDto;
import com.turev.employeeservice.entity.Employee;
import com.turev.employeeservice.mapper.EmployeeMapper;
import com.turev.employeeservice.repository.EmployeeRepository;
import com.turev.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(IllegalArgumentException::new);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee);
    }
}
