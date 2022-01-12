package com.demo2.repo;

import com.demo2.bean.LeaveInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveInfoRepo extends JpaRepository<LeaveInfo,Long> {
    List<LeaveInfo> getByDesignation(String designation);
}
