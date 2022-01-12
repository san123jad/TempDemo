package com.demo1.bean;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveInfo {
    private Long id;
    private String designation;
    private String leaveType;
    private int leaveCount;
}