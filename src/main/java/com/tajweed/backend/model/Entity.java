package com.tajweed.backend.model;

import org.springframework.data.annotation.Id;

public class Entity {
    @Id
    private String id;


    private Boolean isActive;

    public Entity() {

    }

    public Entity(String id, Boolean isActive) {
        this.id = id;
        this.isActive = isActive;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
