package com.udacity.critter.system.service;

import com.udacity.critter.system.dto.ScheduleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    //Interface for ScheduleService class

    ScheduleDTO createSchedule(ScheduleDTO scheduleDTO);
    List<ScheduleDTO> getAllSchedules();
    List<ScheduleDTO> getScheduleForPet(Long petId);
    List<ScheduleDTO> getScheduleForEmployee(Long employeeId);
    List<ScheduleDTO> getScheduleForCustomer(Long customerId);
}
