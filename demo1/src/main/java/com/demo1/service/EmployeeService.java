package com.demo1.service;

import com.demo1.bean.Employee;
import com.demo1.commonbean.ErrorResponse;
import com.demo1.exception.AppException;
import com.demo1.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo empRepo;

    public Employee getById(String eid) {
        Optional<Employee> userProfileFromDB=empRepo.findByEmpId(eid);
        if(!userProfileFromDB.isPresent()){
            throw AppException.builder()
                    .error(ErrorResponse.builder()
                            .errorCode("EMPLOYEE ERROR")
                            .httpStatus(HttpStatus.NOT_FOUND)
                            .error("Employee is not found").build())
                    .build();
        }
        else{
            return userProfileFromDB.get();
        }
    }

    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        Optional<Employee> userProfileFromDB=empRepo.findByEmpId(employee.getEmpId());
        if(!userProfileFromDB.isPresent()){
            throw AppException.builder()
                    .error(ErrorResponse.builder()
                            .errorCode("EMPLOYEE ERROR")
                            .httpStatus(HttpStatus.NOT_FOUND)
                            .error("Employee is not found").build())
                    .build();
        }
        else{
            Employee dbEmp=userProfileFromDB.get();
            dbEmp.setDesignation(employee.getDesignation());
            dbEmp.setDateOfJoining(employee.getDateOfJoining());
            return empRepo.save(dbEmp);
        }
    }
}
