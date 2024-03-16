/*package com.example.Projet9;


import com.example.Projet9.DTO.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MediLaboSolutionsTest {


    @Autowired
    private MockMvc mockMvc;



    @Test
    public void personLoad() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/listPerson")).andDo(print());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        List<Person> persons = mapper.readValue(contentAsString, new TypeReference<List<Person>>() {
            });
            assertThat(persons.size()).isGreaterThan(2);

            int initialNumber = persons.size();

            resultActions =
                    mockMvc.perform(post("/person")
                            .contentType("Data.json")
                            .param("firstName", "Test")
                            .param("lastName", "TestNone")
                            .param("birthday", "1966-12-31")
                            .param("genre", "F")
                            .param("address", "1 Brookside St")
                            .param("phone", "100-222-3333")
                    );
            result = resultActions.andReturn();
            contentAsString = result.getResponse().getContentAsString();
            persons = mapper.readValue(contentAsString, new TypeReference<List<Person>>() {
            });
            assertThat(persons.size()).isEqualTo(initialNumber+1);
        resultActions =
                mockMvc.perform(put("/person")
                        .contentType("Data.json")
                        .param("firstName", "Test")
                        .param("lastName", "TestNoneBis")
                        .param("birthday", "1966-12-31")
                        .param("genre", "F")
                        .param("address", "1 Brookside St")
                        .param("phone", "100-222-3333")
                );
        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();
        persons = mapper.readValue(contentAsString, new TypeReference<List<Person>>() {
        });
        assertThat(persons.size()).isEqualTo(initialNumber+1);
    }

    @Test
    public void getPersonInfoWithNameOnly() throws Exception{
        ResultActions resultActions = mockMvc.perform(get("/PersonInfo")
                .contentType("Data.json")
                .param("lastName", "TestNone")
        );
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        List<Person> personList = mapper.readValue(contentAsString, new TypeReference<List<Person>>() {
        });
        assertThat(personList.size()).isGreaterThan(1);

        for (Person person : personList) {
            assertThat(person.getLastName()).isEqualTo("TestNone");
        }
    }
    }


*/