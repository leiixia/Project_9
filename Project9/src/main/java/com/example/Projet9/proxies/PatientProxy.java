package com.example.Projet9.proxies;

import com.example.Projet9.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

////Proxy of PatientMservice////
@FeignClient(name = "gateway", url = "${link.to.gateway")
public interface PatientProxy {

    @GetMapping(value = "/patient/{id}")
    Patient getPatient(@PathVariable("id") int id);

    @GetMapping(value = "/patient")
    Patient getPatient(@RequestParam String firstName, String lastName);

    @GetMapping(value = "/patientList")
    List<Patient> getPatients();

    @PostMapping(value = "/patient")
    void savePatient(Patient patient);

    @PutMapping(value ="/patient")
    void updatePatient(Patient patient);

    @DeleteMapping(value ="/patient")
    void deleteNoteByPatient(int id);

    @DeleteMapping(value = "/patient/{id}")
    void deletePatient(@PathVariable("id") int id);

    @DeleteMapping(value ="/patient")
    void deleteNote(String id);


}

