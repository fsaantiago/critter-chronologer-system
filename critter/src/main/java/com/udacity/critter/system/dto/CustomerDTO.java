package com.udacity.critter.system.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Define a DTO (Data Transfer Object) class for the Customer entity. This class should contain the following fields:
@Setter
@Getter
public class CustomerDTO {
    private Long id; //Unique identifier for the customer
    private String name; //Name of the customer
    private String phoneNumber; //Phone number of the customer
    private String notes; //Any additional notes regarding the customer

    //List of pet IDs that the customer has
    private List<Long> petIds;

    public CustomerDTO() {
    }
}
