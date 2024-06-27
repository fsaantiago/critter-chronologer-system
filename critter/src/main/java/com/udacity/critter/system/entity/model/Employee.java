package com.udacity.critter.system.entity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

//OK

//Entity class for Employee
//Getters and Setters are provided for all fields
@Entity
@Getter
@Setter
public class Employee {

    //Unique identifier for the employee
    //Generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //Skills that the employee has
    @ElementCollection(targetClass = EmployeeSkill.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "employee_skill", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "skill")
    private Set<EmployeeSkill> skills;

    //Days of the week that the employee is available
    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "employee_day_available", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "day_available")
    private Set<DayOfWeek> daysAvailable;
}
