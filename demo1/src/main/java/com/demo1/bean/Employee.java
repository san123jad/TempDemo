package com.demo1.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Employee id is a mandatory field")
    @Column(name = "employee_id")
    private String empId;

    @NotBlank(message = "Designation is a mandatory field")
    @Column(name = "designation")
    private String designation;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "doj")
    private LocalDate dateOfJoining;
}
