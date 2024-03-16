package com.example.AssessmentMservice.proxies;

import com.example.AssessmentMservice.dto.NoteDto;
import com.example.AssessmentMservice.Assessment;
import com.example.AssessmentMservice.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

///Proxy of AssessmentMservice////
@FeignClient(name = "gateway", url = "${link.to.gateway}")
public interface AssessmentProxy {

    @GetMapping(value = "/assessment/{id}")
    Assessment diabetesAssessment(@PathVariable("id") int patient_id);

    @GetMapping(value = "/patient/{id}")
    Patient getPatient(@PathVariable("id") int id);

    @GetMapping(value = "/note/patient/{id}")
    List<NoteDto> getNotesByPatientId(@PathVariable("id") int Patient_id);
}
