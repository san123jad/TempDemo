package com.demo1.controller;

import com.demo1.apiproxy.LeaveAPIProxy;
import com.demo1.bean.Employee;
import com.demo1.bean.LeaveInfo;
import com.demo1.commonbean.ErrorResponse;
import com.demo1.exception.AppException;
import com.demo1.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class WebController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    LeaveAPIProxy leaveAPIProxy;

    @GetMapping("/getbyeid/{eid}")
    public Employee getById(@PathVariable String eid){
        return employeeService.getById(eid);
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody @Validated Employee employee, Errors errors){
        log.info("Employee Obj:::"+employee.toString());
        if (errors.hasFieldErrors()) {
            throw AppException.builder().error(
                    ErrorResponse.builder().errorCode("Employee Error")
                            .fieldErrors(errors.getFieldErrors()).build()).build();
        }
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody @Validated Employee employee, Errors errors){
        log.info("Employee Obj:::"+employee.toString());
        if (errors.hasFieldErrors()) {
            throw AppException.builder().error(
                    ErrorResponse.builder().errorCode("Employee Error")
                            .fieldErrors(errors.getFieldErrors()).build()).build();
        }
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/feignTest/{desig}")
    public List<LeaveInfo> feignTestCase(@PathVariable String desig){
        return leaveAPIProxy.getByDesi(desig);
    }
}