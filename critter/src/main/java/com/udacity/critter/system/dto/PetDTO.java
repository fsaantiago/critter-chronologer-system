package com.udacity.critter.system.dto;

import com.udacity.critter.system.entity.model.PetType;

import java.time.LocalDate;

//Class to represent the PetDTO
public class PetDTO {
    private Long id;
    private PetType type;

    private String name;
    private LocalDate birthDate;
    private String notes;
    private Long ownerId;

    public PetDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    // Method added to fix the error
    public void setType(com.udacity.critter.system.entity.PetType petType) {
    }
}
