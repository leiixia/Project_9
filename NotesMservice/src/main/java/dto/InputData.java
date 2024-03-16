package dto;

import domain.Note;

import java.util.List;

public class InputData {
    List<Note> notes;
    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }



}
