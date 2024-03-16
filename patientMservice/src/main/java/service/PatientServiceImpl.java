package service;


import domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;


    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatient(int id) {
        return patientRepository.findById(id).get();
    }

    public Optional<Patient> getPatient(String firstName, String lastName) {
        return patientRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Patient> PatientsList() {
        return patientRepository.findAll();
    }

    @Override
    public void savePatient(Patient patient) {

    }


    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
