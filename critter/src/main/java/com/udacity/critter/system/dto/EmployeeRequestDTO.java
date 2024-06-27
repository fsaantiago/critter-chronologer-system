package com.udacity.critter.system.dto;

import com.udacity.critter.system.entity.model.EmployeeSkill;

import java.time.LocalDate;
import java.util.Set;

//Class to represent the request for an employee
public class EmployeeRequestDTO {
    private LocalDate date;
    private Set<EmployeeSkill> skills;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }
}
