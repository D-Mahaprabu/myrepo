package com.example.employees.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "employees")
public class Employees {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeid" )
    private Long employeeId;
    @Column(name = "employeename",nullable = false)
    private String employeeName;
    @Column(name = "employeeage",nullable = false)
    private Integer employeeAge;
    @Column(name = "employeeaddress",nullable = false)
    private String employeeAddress;
    @Column(name = "employeecontact",nullable = false)
    private Long employeeContact;
}
