package com.udacity.critter.system.service;

import com.udacity.critter.system.data.EntityMapper;
import com.udacity.critter.system.dto.ScheduleDTO;
import com.udacity.critter.system.entity.model.Schedule;
import com.udacity.critter.system.repository.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        // Convert the ScheduleDTO to a Schedule entity and save it to the database.
        Schedule schedule = EntityMapper.toEntity(scheduleDTO);
        schedule = scheduleRepository.save(schedule);
        return EntityMapper.toDto(schedule);
    }

    @Override
    public List<ScheduleDTO> getAllSchedules() {
        // Return a list of all schedules in the database.
        return scheduleRepository.findAll().stream()
                .map(EntityMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getScheduleForPet(Long petId) {
        // Return a list of schedules for a pet.
        return scheduleRepository.findByPets_Id(petId).stream()
                .map(EntityMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getScheduleForEmployee(Long employeeId) {
        // Return a list of schedules for an employee.
        return scheduleRepository.findByEmployees_Id(employeeId).stream()
                .map(EntityMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getScheduleForCustomer(Long customerId) {
        // Return a list of schedules for a customer.
        return scheduleRepository.findByPets_Owner_Id(customerId).stream()
                .map(EntityMapper::toDto)
                .collect(Collectors.toList());
    }
}
