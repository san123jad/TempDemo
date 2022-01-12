package com.demo2.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class LeaveInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "designation")
    private String designation;
    @Column(name = "leave_type")
    private String leaveType;
    @Column(name = "leave_count")
    private int leaveCount;
}
