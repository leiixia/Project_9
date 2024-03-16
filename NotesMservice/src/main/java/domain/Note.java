package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Note {

    @Id
    private int id;

    @Column(name = "patient_id")
    private int patient_Id;
    @Column(name = "patient_name")
    private String patient_Name;
    @Column(name = "note")
    private String note;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_Id() {
        return patient_Id;
    }

    public void setPatient_Id(int patient_Id) {
        this.patient_Id = patient_Id;
    }

    public String getPatient_Name() {
        return patient_Name;
    }

    public void setPatient_Name(String patient_Name) {
        this.patient_Name = patient_Name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



}
