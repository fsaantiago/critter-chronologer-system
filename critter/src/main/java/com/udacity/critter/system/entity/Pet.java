package com.udacity.critter.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Unique identifier for the pet using IDENTITY strategy
    private Long id;

    @Enumerated(EnumType.STRING) //Type of the pet using STRING EnumType
    private PetType type; //Type of the pet

    private String name; //Name of the pet

    @ManyToOne(fetch = FetchType.LAZY) //Owner of the pet using LAZY fetch type for optimization
    @JoinColumn(name = "customer_id")
    private Customer owner;

    private LocalDate birthDate;
    private String notes;
}
