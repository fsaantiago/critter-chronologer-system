package com.udacity.critter.system.entity.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Customer {

    //Unique identifier for the customer
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Notes about the customer
    @Column(length = 3000)
    private String notes;

    //Name of the customer
    private String name;
    private String phoneNumber;

    //List of pets owned by the customer
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets = new ArrayList<>();
}
