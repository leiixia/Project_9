package controller;


import domain.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.NoteService;

import java.util.List;

@Controller
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping("/note/patient/{id}")
    public ResponseEntity<List<Note>> getNotesByPatientId(@PathVariable("id") int patientId){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getNotesByPatient(patientId));
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getNoteById(id));
    }

    @PostMapping("/note")
    public ResponseEntity createNote(@RequestBody Note note){
        noteService.createNote(note);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/note")
    public ResponseEntity updateNote(@RequestBody Note note){
        noteService.updateNote(note);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity deleteNoteById(@PathVariable("id") String id){
        noteService.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/note/patient/{id}")
    public ResponseEntity deleteNoteByPatient(@PathVariable("id") int patientId){
        noteService.deleteNoteByPatientId(patientId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
