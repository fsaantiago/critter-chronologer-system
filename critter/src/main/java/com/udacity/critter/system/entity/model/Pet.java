package com.udacity.critter.system.entity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Pet { //CEntity class that represents a pet.

    //Unique identifier for the pet
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Type of the pet
    @Enumerated(EnumType.STRING)
    private PetType type;

    private String name;

    //Owner of the pet
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer owner;

    //Birth date of the pet
    private LocalDate birthDate;
    private String notes;


}
