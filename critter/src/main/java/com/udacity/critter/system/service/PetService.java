package com.udacity.critter.system.service;

import com.udacity.critter.system.dto.PetDTO;
import com.udacity.critter.system.repository.PetRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Service
public class PetService {

    //Autowired PetRepository
    @Autowired
    private PetRepositoryImpl petRepositoryImpl;

    //PersistenceContext = defines the EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    //Save a pet manually
    public PetDTO savePet(PetDTO petDTO) {
        //Save a pet
        entityManager.getTransaction().begin();

        //Persist the pet
        entityManager.getTransaction().commit();
        return petDTO;
    }

    //Get a pet by ID
    public PetDTO getPet(Long petId) {
        return null;
    }

    //Get all pets
    public List<PetDTO> getAllPets() {
        return null;
    }

    //Get pets by owner
    public List<PetDTO> getPetsByOwner(Long ownerId) {
        return null;
    }
}
