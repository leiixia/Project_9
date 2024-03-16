package com.example.Projet9.proxies;

import com.example.Projet9.domain.Assessment;
import com.example.Projet9.domain.Patient;
import com.example.Projet9.domain.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

///Proxy of Diabates AssessmentMservice////
@FeignClient(name = "gateway", url = "${link.to.gateway")
public interface AssessmentProxy {

    @GetMapping(value = "/assessment/{id}")
    Assessment diabetesAssessment(@PathVariable("id") int patient_Id);

    @GetMapping(value = "/patient/{id}")
    Patient getPatient(@PathVariable("id") int id);

    @GetMapping(value = "/note/patient/{id}")
    List<Note> getNotesByPatientId(@PathVariable("id") int Patient_Id);

    @GetMapping(value = "/assessment/{id}")
    Assessment getDiabetesAssessment(int patientId);
}
