package com.udacity.critter.system.data;

import com.udacity.critter.system.entity.model.Customer;
import com.udacity.critter.system.entity.model.Employee;
import com.udacity.critter.system.entity.model.Pet;

import com.udacity.critter.system.dto.CustomerDTO;
import com.udacity.critter.system.dto.EmployeeDTO;
import com.udacity.critter.system.dto.PetDTO;
import com.udacity.critter.system.dto.ScheduleDTO;

import com.udacity.critter.system.entity.model.Schedule;

import java.util.stream.Collectors;
//Class to convert entities to DTOs and vice versa
public class EntityMapper {
    public static CustomerDTO toDto(Customer entity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(entity.getId());
        customerDTO.setName(entity.getName());
        customerDTO.setPhoneNumber(entity.getPhoneNumber());
        customerDTO.setNotes(entity.getNotes());
        customerDTO.setPetIds(entity.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        return customerDTO;
    }
    //Method to convert CustomerDTO to Customer entity
    public static Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setNotes(dto.getNotes());
        return customer;
    }
    //Method to convert Employee entity to EmployeeDTO
    public static EmployeeDTO toDto(Employee entity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(entity.getId());
        employeeDTO.setName(entity.getName());
        employeeDTO.setSkills(entity.getSkills());
        employeeDTO.setDaysAvailable(entity.getDaysAvailable());
        return employeeDTO;
    }
    //Method to convert EmployeeDTO to Employee entity
    public static Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setSkills(dto.getSkills());
        employee.setDaysAvailable(dto.getDaysAvailable());
        return employee;
    }
    //Method to convert Pet entity to PetDTO
    public static PetDTO toDto(Pet entity) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(entity.getId());
        petDTO.setName(entity.getName());
        petDTO.setType(entity.getType());
        petDTO.setBirthDate(entity.getBirthDate());
        petDTO.setNotes(entity.getNotes());
        petDTO.setOwnerId(entity.getOwner().getId());
        return petDTO;
    }
    //Method to convert PetDTO to Pet entity
    public static Pet toEntity(PetDTO dto) {
        Pet pet = new Pet();
        pet.setId(dto.getId());
        pet.setName(dto.getName());
        pet.setType(dto.getType());
        pet.setBirthDate(dto.getBirthDate());
        pet.setNotes(dto.getNotes());
        Customer owner = new Customer();
        owner.setId(dto.getOwnerId());
        pet.setOwner(owner);
        return pet;
    }
    //Method to convert Schedule entity to ScheduleDTO
    public static ScheduleDTO toDto(Schedule entity) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(entity.getId());
        scheduleDTO.setDate(entity.getDate());
        scheduleDTO.setActivities(entity.getActivities());
        scheduleDTO.setEmployeeIds(entity.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()));
        scheduleDTO.setPetIds(entity.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        return scheduleDTO;
    }
    //Method to convert ScheduleDTO to Schedule entity
    public static Schedule toEntity(ScheduleDTO dto) {
        Schedule schedule = new Schedule();
        schedule.setId(dto.getId());
        schedule.setDate(dto.getDate());
        schedule.setActivities(dto.getActivities());
        schedule.setEmployees(dto.getEmployeeIds().stream().map(id -> {
            Employee employee = new Employee();
            employee.setId(id);
            return employee;
        }).collect(Collectors.toList()));
        return schedule;
    }
}
