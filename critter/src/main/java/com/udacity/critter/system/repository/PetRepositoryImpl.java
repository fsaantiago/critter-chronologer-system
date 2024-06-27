package com.udacity.critter.system.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetRepositoryImpl {
    //Class used to implement the PetRepository

    @Bean
    public <PetRepository> PetRepository petRepository() {
        return (PetRepository) new PetRepositoryImpl();
    }

}
