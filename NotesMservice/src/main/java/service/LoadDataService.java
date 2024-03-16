package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Note;
import dto.InputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import repository.NoteRepository;
import org.springframework.core.io.Resource;


import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class LoadDataService {
    @Autowired
    private NoteRepository noteRepository;

            public void loadData(){
                ObjectMapper objectMapper = new ObjectMapper();
                try{
                    Resource resource = new ClassPathResource("Data.json");
                    File file = resource.getFile();
                    InputData data = objectMapper.readValue(file, InputData.class);
                    List<Note> notes = data.getNotes();
                    noteRepository.saveAll(notes);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
}
