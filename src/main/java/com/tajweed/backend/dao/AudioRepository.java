package com.tajweed.backend.dao;

import com.tajweed.backend.model.Audio;
import org.springframework.data.repository.CrudRepository;

public interface AudioRepository extends CrudRepository<Audio, String> {
}
