package com.alex.d.security.models;


import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.Objects;


@Repository
@Entity
@Table(name = "patients")
public class PatientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "day_of_birth")
    private String dob;

    @Column(name = "diagnosis")
    private String diagnosis;


    public PatientsModel(String first_name, String last_name, String dob, String diagnosis) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.diagnosis = diagnosis;
    }

    public PatientsModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "PatientsModel{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob='" + dob + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
