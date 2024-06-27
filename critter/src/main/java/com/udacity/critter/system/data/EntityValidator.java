package com.udacity.critter.system.data;

import com.udacity.critter.system.entity.model.Customer;
import com.udacity.critter.system.entity.model.Employee;
import com.udacity.critter.system.entity.model.Pet;
import com.udacity.critter.system.entity.model.Schedule;
import com.udacity.critter.system.entity.model.EmployeeSkill;
import com.udacity.critter.system.entity.model.PetType;

public class EntityValidator {
    // Validate the Customer entity
    public static boolean isValid(Customer entity) {
        return entity != null && entity.getName() != null && !entity.getName().isEmpty();
    }
    // Validate the Employee entity
    public static boolean isValid(String entity) {
        return entity != null && !entity.isEmpty();
    }
    // Validate the Pet entity
    public static boolean isValid(Employee entity) {
        return entity != null && entity.getName() != null && !entity.getName().isEmpty();
    }
    // Validate the Schedule entity
    public static boolean isValid(Pet entity) {
        return entity != null && entity.getName() != null && !entity.getName().isEmpty();
    }
    // Validate the EmployeeSkill entity
    public static boolean isValid(Schedule entity) {
        return entity != null;
    }
    // Validate the PetType entity
    public static boolean isValid(EmployeeSkill entity) {
        return entity != null;
    }
    // Validate the PetType entity
    public static boolean isValid(PetType entity) {
        return entity != null;
    }
}
//OK

