package com.udacity.critter.system.controller;

import com.udacity.critter.system.dto.PetDTO;
import com.udacity.critter.system.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController for Pet
//Request mappings for saving a pet, getting a pet by ID, getting all pets, and getting pets by owner
@RestController
@RequestMapping("/pet")
public class PetController {

    //Autowired PetService
    @Autowired
    private PetService petService;

    //Save a pet
    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        return petService.savePet(petDTO);
    }

    //Get a pet by ID
    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return petService.getPet(petId);
    }
    //Get all pets
    @GetMapping("/all")
    public List<PetDTO> getAllPets() {
        return petService.getAllPets();
    }

    //Get pets by owner
    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        return petService.getPetsByOwner(ownerId);
    }
}
