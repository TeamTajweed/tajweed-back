package com.tajweed.backend.dao;

import com.tajweed.backend.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
