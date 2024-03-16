package com.example.AssessmentMservice.service;

import com.example.AssessmentMservice.dto.NoteDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TriggerWarning {

    List<String> triggers = new ArrayList<>();
    {
        triggers.add(("Hémoglobine A1C").toLowerCase());
        triggers.add(("Microalbumine").toLowerCase());
        triggers.add(("Taille").toLowerCase());
        triggers.add(("Poids").toLowerCase());
        triggers.add(("Fumeur/Fumeuse").toLowerCase());
        triggers.add(("Anormal").toLowerCase());
        triggers.add(("Cholesteérol...").toLowerCase());
        triggers.add(("Vertiges").toLowerCase());
        triggers.add(("Rechute").toLowerCase());
        triggers.add(("Réaction").toLowerCase());
        triggers.add(("Anticorps").toLowerCase());
    }

    public int countTriggersWarning(List<NoteDto> noteDtos){
        List<String> note = getNotes(noteDtos);

        Set<String> triggersWarningInPatientNotes = new HashSet<>();

        for (String triggerWarning : triggers){
            if(note.stream().anyMatch(notes -> note.contains(triggerWarning))){
                triggersWarningInPatientNotes.add(triggerWarning);
            }
        }
        return Long.valueOf(triggersWarningInPatientNotes.stream().count()).intValue();
    }

    private List<String> getNotes(List<NoteDto> noteDtos){
        return noteDtos
                .stream()
                .map(NoteDto::getNote)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
