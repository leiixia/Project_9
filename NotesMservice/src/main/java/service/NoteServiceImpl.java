package service;


import domain.Note;
import org.springframework.stereotype.Service;
import repository.NoteRepository;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    public NoteServiceImpl (NoteRepository noteRepository) {
         this.noteRepository = noteRepository;
    }

    public List<Note> getNotesByPatient(int patientId){
        return noteRepository.findByPatientId(patientId);
    }

    public Note getNoteById(String id){
        return noteRepository.findById(id).get();
    }

    public Note createNote(Note note){
        noteRepository.insert(note);
        return note;
    }

    public Note updateNote(Note note){
        noteRepository.save(note);
        return note;
    }

    public void deleteNoteById(String id){
        noteRepository.deleteById(id);
    }

    @Override
    public void deleteNoteByPatientId(int patientId) {
        List<Note> allPatientNotes = noteRepository.findByPatientId(patientId);
        noteRepository.deleteAll(allPatientNotes);
    }

}
