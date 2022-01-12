package com.demo2.service;

import com.demo2.bean.LeaveInfo;
import com.demo2.repo.LeaveInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveInfoService {

    @Autowired
    LeaveInfoRepo leaveInfoRepo;

    public List<LeaveInfo> getByDesi(String designation) {
        return leaveInfoRepo.getByDesignation(designation);
    }
}
