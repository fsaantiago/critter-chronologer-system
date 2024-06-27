package com.udacity.critter.system.controller;

import com.udacity.critter.system.dto.CustomerDTO;
import com.udacity.critter.system.service.UserService;
import com.udacity.critter.system.dto.EmployeeDTO;
import com.udacity.critter.system.dto.EmployeeRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {

        //Create a new customer and save it to the database.
        return userService.saveCustomer(customerDTO);
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {

        //Return a list of all customers in the database.
        return userService.getAllCustomers();
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

        //Create a new employee and save it to the database.
        return userService.saveEmployee(employeeDTO);
    }

    @GetMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {

        //Return an employee by ID.
        return userService.getEmployee(employeeId);
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {

        //Set the days that the employee is available
        userService.setAvailability(daysAvailable, employeeId);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeRequestDTO) {

        //Return a list of employees who are available for the given service.
        return userService.findEmployeesForService(employeeRequestDTO);
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId) {

        //Return the owner of a pet by the pet's ID.
        return userService.getOwnerByPet(petId);
    }
}
