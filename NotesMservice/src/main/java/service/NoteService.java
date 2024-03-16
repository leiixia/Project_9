package service;



import domain.Note;

import java.util.List;

public interface NoteService {
    List<Note> getNotesByPatient(int patientId);
    Note getNoteById(String id);
    Note createNote (Note note);
    Note updateNote (Note note);
    void deleteNoteById(String id);
    void deleteNoteByPatientId(int patientId);
}
