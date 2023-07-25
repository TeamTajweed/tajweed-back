package com.tajweed.backend.dao;

import com.tajweed.backend.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
<<<<<<< Updated upstream
=======
    // Mise à jour d'un étudiant par ID
    Student save(Student student); // Lorsque l'étudiant a un ID existant, cela mettra à jour l'enregistrement existant
>>>>>>> Stashed changes
}
