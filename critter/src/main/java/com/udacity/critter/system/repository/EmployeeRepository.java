package com.udacity.critter.system.repository;

import com.udacity.critter.system.entity.model.Employee;
import com.udacity.critter.system.entity.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Interface used for build a repository for Employee

    List<Employee> findBySkillsInAndDaysAvailable(Collection<Set<EmployeeSkill>> skills, Set<DayOfWeek> daysAvailable);

    Collection<Object> findAllByDaysAvailableContaining(DayOfWeek dayOfWeek);
}
