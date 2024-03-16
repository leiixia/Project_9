package com.example.Projet9.proxies;


import com.example.Projet9.domain.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

////Proxy of NotesMservice ////
@FeignClient(name = "gateway", url = "${link.to.gateway")
public interface NoteProxy {

    @GetMapping(value = "/note/patient/{id}")
    List<Note> getNoteByPatientId(@PathVariable("id") int Patient_id);

    @GetMapping(value = "/note/{id}")
    Note getNoteById(@PathVariable("id") String id);

    @PostMapping(value = "/note")
    void createNote(Note note);

    @PutMapping(value = "/note")
    void updateNote(Note note);

    @DeleteMapping(value = "/note/{id}")
    void deleteNote(@PathVariable("id") String id);

    @DeleteMapping(value = "/note/patient/{id}")
    void deleteNoteByPatientId(@PathVariable("id") int patientId);
}
