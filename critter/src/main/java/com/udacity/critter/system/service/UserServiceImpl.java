package com.udacity.critter.system.service;

import com.udacity.critter.system.dto.CustomerDTO;
import com.udacity.critter.system.dto.EmployeeDTO;
import com.udacity.critter.system.dto.EmployeeRequestDTO;

import com.udacity.critter.system.entity.Customer;
import com.udacity.critter.system.entity.Employee;
import com.udacity.critter.system.entity.Pet;

import com.udacity.critter.system.repository.CustomerRepository;
import com.udacity.critter.system.repository.EmployeeRepository;
import com.udacity.critter.system.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    // UserServiceImpl class implements UserService interface and provides the implementation for the methods in the interface

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PetRepository petRepository;

    // Method to save a customer
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = convertDtoToEntity(customerDTO);
        customer = customerRepository.save(customer);
        return convertEntityToDto(customer);
    }

    // Method to get a customer by ID
    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<com.udacity.critter.system.entity.model.Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::saveCustomer).collect(Collectors.toList());
    }

    // Method to save an employee
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertDtoToEntity(employeeDTO);
        employee = employeeRepository.save(employee);
        return convertEntityToDto(employee);
    }

    // Method to get an employee by ID
    @Override
    public EmployeeDTO getEmployee(Long employeeId) {
        com.udacity.critter.system.entity.model.Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        return convertEntityToDto(employee);
    }

    // Method to get the owner of a pet
    @Override
    public CustomerDTO getOwnerByPet(Long petId) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new RuntimeException("Pet not found"));
        Customer customer = pet.getOwner();
        return convertEntityToDto(customer);
    }

    // Method to set the availability of an employee
    @Override
    public void setAvailability(Set<DayOfWeek> daysAvailable, Long employeeId) {
        com.udacity.critter.system.entity.model.Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setDaysAvailable(daysAvailable);
        employeeRepository.save(employee);
    }

    // Method to find employees who are available for a given service
    @Override
    public List<EmployeeDTO> findEmployeesForService(EmployeeRequestDTO employeeRequestDTO) {
        List<Employee> employees = employeeRepository.findAllByDaysAvailableContaining(employeeRequestDTO.getDate().getDayOfWeek())
                .stream().filter(employee -> employee.getSkills().containsAll(employeeRequestDTO.getSkills()))
                .collect(Collectors.toList());
        return employees.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    // Method to convert a CustomerDTO to a Customer entity
    private Customer convertDtoToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setNotes(customerDTO.getNotes());
        return customer;
    }

    // Method to convert a Customer entity to a CustomerDTO
    private CustomerDTO convertEntityToDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setNotes(customer.getNotes());
        customerDTO.setPetIds(customer.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        return customerDTO;
    }

    // Method to convert an EmployeeDTO to an Employee entity
    private Employee convertDtoToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setSkills(employeeDTO.getSkills());
        employee.setDaysAvailable(employeeDTO.getDaysAvailable());
        return employee;
    }

    // Method to convert an Employee entity to an EmployeeDTO
    private EmployeeDTO convertEntityToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSkills(employee.getSkills());
        employeeDTO.setDaysAvailable(employee.getDaysAvailable());
        return employeeDTO;
    }
}
