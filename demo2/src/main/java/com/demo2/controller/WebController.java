package com.demo2.controller;

import com.demo2.bean.LeaveInfo;
import com.demo2.service.LeaveInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class WebController {

    @Autowired
    LeaveInfoService leaveService;

    @GetMapping("/getbyeid/{designation}")
    public List<LeaveInfo> getByDesi(@PathVariable String designation){
        return leaveService.getByDesi(designation);
    }
}
