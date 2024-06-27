package com.udacity.critter.system.service;

import com.udacity.critter.system.dto.CustomerDTO;
import com.udacity.critter.system.dto.EmployeeDTO;
import com.udacity.critter.system.dto.EmployeeRequestDTO;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

//Define a service class for the User entity. This class should contain methods for creating customers,
//retrieving customers, creating employees, retrieving employees, setting an employee's availability, and finding employees by skill.

public interface UserService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO); //Create a new customer and save it to the database.
    List<CustomerDTO> getAllCustomers(); //Return a list of all customers in the database.
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO); //Create a new employee and save it to the database.
    EmployeeDTO getEmployee(Long employeeId); //Return an employee by ID.
    CustomerDTO getOwnerByPet(Long petId); //Return the owner of a pet.
    void setAvailability(Set<DayOfWeek> daysAvailable, Long employeeId); //Set the days that the employee is available.
    List<EmployeeDTO> findEmployeesForService(EmployeeRequestDTO employeeRequestDTO); //Return a list of employees who are available for the given service.
}
