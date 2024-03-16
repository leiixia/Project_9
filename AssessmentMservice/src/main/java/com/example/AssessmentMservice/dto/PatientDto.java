package com.example.AssessmentMservice.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class PatientDto {

    private int id;
    private LocalDate birthday;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
