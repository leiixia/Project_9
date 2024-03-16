package service;



import domain.Patient;


import java.util.List;
import java.util.Optional;

public interface PatientService {

    public Patient getPatient(int id);

    public Optional<Patient> getPatient(String firstName, String lastName );

    List<Patient> PatientsList();

    public void savePatient(Patient patient);


    public void deletePatient(int id);


}
