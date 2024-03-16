package controller;



import Proxy.PatientProxy;
import domain.Patient;
import dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import service.PatientService;


@Service
@RestController
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }
    @Autowired
    PatientDto patientDto;

    private PatientProxy proxy;


    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatient(id));
    }

    @GetMapping(value = "/patient")
    public ResponseEntity getPatient(@RequestParam String firstName, @RequestParam String lastName){
        return patientService.getPatient(firstName, lastName).map(ResponseEntity::ok).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping(value = "/patientList")
    public ResponseEntity getPatientList(){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.PatientsList());
    }

    @PutMapping(value = "/patient/update")
    public ResponseEntity updatePatient(@RequestParam Patient patient){
        patientService.savePatient(patient);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping(value = "/patient/add)")
    public ResponseEntity addPatient(@RequestParam Patient patient){
        patientService.savePatient(patient);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/patient/{id]")
    public ResponseEntity deletePatient(@PathVariable("id") int id){
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
