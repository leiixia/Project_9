package com.example.AssessmentMservice.controller;

import com.example.AssessmentMservice.service.AssessmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AssessmentController {

    AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService){
        this.assessmentService = assessmentService;
    }

    @GetMapping("/assessment/{id}")
    public ResponseEntity diabetesAssessment(@PathVariable("id") int patient_id){
        return ResponseEntity.status(HttpStatus.OK).body(assessmentService.diabetesAssessment(patient_id));
    }
}
