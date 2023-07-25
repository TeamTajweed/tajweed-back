package com.tajweed.backend;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
<<<<<<< Updated upstream
import com.mongodb.client.MongoClient;
import com.mongodb.client.internal.MongoClientImpl;
import com.tajweed.backend.dao.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

// ajout de ma part (guillaume) import des classes pour le CRUD dans le fichier
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;

import com.tajweed.backend.dao.StudentRepository;
import com.tajweed.backend.model.Student;
import org.springframework.data.repository.CrudRepository;




@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(BackendApplication.class);

	@Autowired
	private StudentRepository StudentRepository;



	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

<<<<<<< Updated upstream
	private static Logger LOG = LoggerFactory
			.getLogger(BackendApplication.class);

	@Autowired
	private StudentRepository studentRepository;

=======
>>>>>>> Stashed changes
	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");
		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}

		// Création d'un nouvel étudiant
		Student newStudent = new Student();
		newStudent.setProgress("En cours");
		newStudent.setName("James");
		newStudent.setPassword("monmotdepasse");
		newStudent.setEmail("johndoe@example.com");

		StudentRepository.save(newStudent);

		LOG.info("Nouvel étudiant inséré avec succès !");

		// Rechercher un étudiant par ID
		String StudentIdToUpdate = "64bfca886bea761d7a15ca3f";
		StudentRepository.findById(StudentIdToUpdate).ifPresent(student -> {
			// Mise à jour des données de l'étudiant
			student.setProgress("Terminé");
			student.setPassword("nouveaumotdepasse");
			student.setName("NouveauNom");
			StudentRepository.save(student);
			LOG.info("Étudiant avec ID {} mis à jour avec succès !", student.getId());
		});

		// Suppression d'un étudiant par ID
		String StudentIdToDelete = "64bfca886bea761d7a15ca3f";
		StudentRepository.deleteById(StudentIdToDelete);
		LOG.info("Étudiant avec ID {} supprimé avec succès !", StudentIdToDelete);


	}
}
