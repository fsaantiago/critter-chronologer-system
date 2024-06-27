package com.udacity.critter.system.entity;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

//Entity class for Employee
//Getters and Setters are provided for all fields
@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //Method to get the skills of the employee
    public Set<EmployeeSkill> getSkills() {
        return skills;
    }
    //Method to set the skills of the employee
    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }
    //Method to get the days available for the employee
    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }
    //Method to set the days available for the employee
    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }
}
