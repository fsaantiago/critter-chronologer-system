package com.udacity.critter.system.repository;

import com.udacity.critter.system.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    //Interface used to build a repository for the Pet entity

    List<Pet> findAllByOwnerId(Long ownerId);
    //Search for a pet by ID
    Pet findPetById(Long petId);
    //Search for a pet by name
    Pet findPetByOwnerId(Long ownerId);
    //Search for a pet by owner ID and pet ID
    Pet findPetByOwnerIdAndPetId(Long ownerId, Long petId);

    Pet findPetByOwnerIdAndPetIdAndPetName(Long ownerId, Long petId, String petName);

    Pet findPetByOwnerIdAndPetName(Long ownerId, String petName);

    Pet findPetByPetId(Long petId);

    Pet findPetByPetName(String petName);

    Pet findPetByOwnerIdAndPetNameAndPetId(Long ownerId, String petName, Long petId);

    Pet findPetByOwnerIdAndPetIdAndPetNameAndPetType(Long ownerId, Long petId, String petName, String petType);

    Pet findPetByOwnerIdAndPetNameAndPetType(Long ownerId, String petName, String petType);

    Pet findPetByPetIdAndPetNameAndPetType(Long petId, String petName, String petType);

    Pet findPetByOwnerIdAndPetIdAndPetType(Long ownerId, Long petId, String petType);

    Pet findPetByOwnerIdAndPetType(Long ownerId, String petType);

    Pet findPetByPetIdAndPetType(Long petId, String petType);

    Pet findPetByPetNameAndPetType(String petName, String petType);

    Pet findPetByOwnerIdAndPetIdAndPetNameAndPetTypeAndNotes(Long ownerId, Long petId, String petName, String petType, String notes);

    Pet findPetByOwnerIdAndPetNameAndPetTypeAndNotes(Long ownerId, String petName, String petType, String notes);
}
