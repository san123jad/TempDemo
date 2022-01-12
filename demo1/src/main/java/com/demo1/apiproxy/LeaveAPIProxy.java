package com.demo1.apiproxy;

import com.demo1.bean.LeaveInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "static-service", url ="localhost:8081" )
public interface LeaveAPIProxy {

    @GetMapping("/getbyeid/{designation}")
    public List<LeaveInfo> getByDesi(@PathVariable String designation);
}
