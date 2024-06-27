package com.udacity.critter.system.repository;

import com.udacity.critter.system.entity.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { //interface used for build the Customer Repository

    List<Customer> findAll();

    //Method to find the customer by the pet id
    default Customer findByPetsId() {
        return findByPetsId(null);
    }

    Customer findByPetsId(Long petId);

    //Method to find the customer by the owner id
    default Customer findByPetsOwnerId() {
        return findByPetsOwnerId(null);
    }

    Customer findByPetsOwnerId(Long ownerId);

    //Method to find the customer by the owner ids
    default Customer findByPetsOwnerIds() {
        return findByPetsOwnerIds(null);
    }

    Customer findByPetsOwnerIds(List<Long> ownerIds);
}
