package com.example.AssessmentMservice.service;

import com.example.AssessmentMservice.Assessment;
import com.example.AssessmentMservice.proxies.AssessmentProxy;
import com.example.AssessmentMservice.domain.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

@Service
public class AssessmentServiceImpl implements AssessmentService{

    private final AssessmentProxy assessmentProxy;
    private final TriggerWarning triggerWarning;

    public AssessmentServiceImpl(AssessmentProxy assessmentProxy, TriggerWarning triggerWarning) {
        this.assessmentProxy = assessmentProxy;
        this.triggerWarning = triggerWarning;
    }

    @Override
    public Assessment diabetesAssessment(int patient_id) {
        int counterTrigger = triggerWarning.countTriggersWarning(assessmentProxy.getNotesByPatientId(patient_id));
        Patient patientDto = assessmentProxy.getPatient(patient_id);
        String gender = patientDto.getGender();
        int age = calculateAge(patientDto.getBirthday());

        if(counterTrigger < 2){
            return Assessment.None;
        } else if (age >=30){
            return Assessment.EarlyOnSet;
        } else if (counterTrigger >= 2) {
            return Assessment.Bordeline;
        } else {
            switch (gender){
                case "Female": {
                    if(counterTrigger >= 7){
                        return Assessment.EarlyOnSet;
                    } else if (counterTrigger >= 4) {
                        return Assessment.InDanger;
                    } else if (counterTrigger <=3) {
                        return Assessment.None;
                    }
                }
                default: {
                    if (counterTrigger >= 5){
                        return Assessment.EarlyOnSet;
                    } else if (counterTrigger >= 3) {
                        return Assessment.InDanger;
                    } else if (counterTrigger <= 2) {
                        return Assessment.None;
                    }
                }
                }
            }
        throw new RuntimeException();
        }

        private int calculateAge(LocalDate birthday){
            LocalDate now = LocalDate.now();
            return Period.between(birthday, now).getYears();
    }
}
