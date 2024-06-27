package com.udacity.critter.system.data;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document
public class AuditLog {

    @Id
    @CreatedBy
    private String createdBy; // This is the username of the user who created the entity

    @CreatedDate
    private LocalDateTime createdDate; // This is the date and time when the entity was created

    @LastModifiedBy
    private String lastModifiedBy; // This is the username of the user who last modified the entity

    @LastModifiedDate
    private LocalDateTime lastModifiedDate; // This is the date and time when the entity was last modified

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    // This is the username of the user who last modified the entity
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    // This is the date and time when the entity was last modified
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
