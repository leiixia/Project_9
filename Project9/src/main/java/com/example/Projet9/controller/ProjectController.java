package com.example.Projet9.controller;


import com.example.Projet9.domain.Patient;
import com.example.Projet9.domain.Note;
import com.example.Projet9.proxies.AssessmentProxy;
import com.example.Projet9.proxies.PatientProxy;
import com.example.Projet9.proxies.NoteProxy;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProjectController {

    private PatientProxy patientProxy;

    private NoteProxy noteProxy;

    private AssessmentProxy assessmentProxy;

    public ProjectController(PatientProxy patientProxy, NoteProxy noteProxy, AssessmentProxy assessmentProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
        this.assessmentProxy = assessmentProxy;
    }


    @GetMapping("/patient/{id}")
    public String patient(@RequestParam int patient_id, Model model,
                          @RequestParam(required = false) String noteId) {
        model.addAttribute("patient", patientProxy.getPatient(patient_id));
        model.addAttribute("notes", noteProxy.getNoteByPatientId(patient_id));
        model.addAttribute("assessment",assessmentProxy.getDiabetesAssessment(patient_id));
        if (noteId != null){
            model.addAttribute("noteToSave", noteProxy.getNoteById(noteId));
        } else {
            model.addAttribute("noteToSave", new Note());
        }
        return "patient";
    }


    @GetMapping("/patientList")
    public String patientList(Model model){
        model.addAttribute("patients", patientProxy.getPatients());
        return "patient-list";
    }


    @GetMapping("/patient/add")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
            return "add-patient";
        }

    @GetMapping("patient/update/{id}")
    public String updatePatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", patientProxy.getPatient(id));
        return "update-patient";
    }


    @PostMapping("/patient/update")
    public String validationUpdatePatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, Model model){
        Patient patientAlreadyCreate = patientProxy.getPatient(patient.getFirstName(), patient.getLastName());
        if(patientAlreadyCreate != null) {
            result.rejectValue("firstName", null,
                    patient.getFirstName() + "" + patient.getLastName() + "is already registered.");
        }
        if(patient.getAddress() == ""){
            patient.setAddress(null);
        }
        if(!result.hasErrors()){
            patientProxy.savePatient(patient);
            return "redirect:/patientList";
        }
        model.addAttribute("patient", patient);
        return "update-patient";
    }

    @PostMapping("/patient/validate")
    public String validationNewPatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, Model model) {
        Patient patientAlreadyCreate = patientProxy.getPatient(patient.getFirstName(), patient.getLastName());
        if (patientAlreadyCreate != null){
            result.rejectValue("firstName", null,
                    patient.getFirstName() + "" + patient.getLastName() + "is already registered");
        }
        if (patient.getAddress() == ""){
            patient.setAddress(null);
        }
        if (!result.hasErrors()){
            patientProxy.savePatient(patient);
            return "redirect:/patientList";
        }
        model.addAttribute("patient", patient);
        return "add-new-patient";
    }

    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") int id, Model model){
        patientProxy.deletePatient(id);
        patientProxy.deleteNoteByPatient(id);
        return "redirect:/patient";
    }

    @GetMapping("/note/delete/{id}")
    public String deleteNote(@PathVariable("id") String id, @RequestParam int patientId){
        patientProxy.deleteNote(id);
        return "redirect:/patient/display?patientId=" + patientId;
    }
}
