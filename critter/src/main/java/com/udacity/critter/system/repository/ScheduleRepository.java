package com.udacity.critter.system.repository;

import com.udacity.critter.system.entity.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //Interface used to build a repository for the Schedule entity
    List<Schedule> findByPets_Id(Long petId);
    List<Schedule> findByEmployees_Id(Long employeeId);
    List<Schedule> findByPets_Owner_Id(Long ownerId);
}
