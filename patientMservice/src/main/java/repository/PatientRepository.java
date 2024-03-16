package repository;


import domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Integer> {

    public Optional<Patient> findByFirstNameAndLastName(String firstName, String lastName);

    }

