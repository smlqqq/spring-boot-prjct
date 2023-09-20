package com.alex.d.security.models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Repository;
@Repository
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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



}
