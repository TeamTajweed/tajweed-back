package com.tajweed.backend.dao;

import com.tajweed.backend.model.Entity;
import org.springframework.data.repository.CrudRepository;

public interface EntityRepository extends CrudRepository<Entity, String> {
    // Mise à jour d'une entity par ID
    Entity save(Entity entity);
}
