package com.udacity.critter.system.entity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
//Entity class for Schedule
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Unique identifier for the schedule

    private LocalDate date; //Date of the schedule

    @ElementCollection(targetClass = EmployeeSkill.class) //Skills that are required for the schedule
    @Enumerated(EnumType.STRING) //EnumType.STRING is used to store the enum name in the database
    @CollectionTable(name = "schedule_activity", joinColumns = @JoinColumn(name = "schedule_id")) //The name of the table that will store the activities
    @Column(name = "activity") //The name of the column that will store the activity
    private Set<EmployeeSkill> activities; //The activities that are required for the schedule

    @ManyToMany //That method defines the relationship with the Pet entity
    @JoinTable(name = "schedule_pet", joinColumns = @JoinColumn(name = "schedule_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets;

    @ManyToMany //That method defines the relationship with the Employee entity
    @JoinTable(name = "schedule_employee", joinColumns = @JoinColumn(name = "schedule_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    public void setPets(List<Long> petIs) {
        //That method convert a list of pet IDs to list of Pet entities
        List <Pet> pets = petIs.stream().map(petId -> {
            Pet pet = new Pet();
            pet.setId(petId);
            return pet;
        }).collect(Collectors.toList());
        this.pets = pets;
    }
}
