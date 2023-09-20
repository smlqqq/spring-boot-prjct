package com.alex.d.security.service;

import com.alex.d.security.models.PatientsModel;
import com.alex.d.security.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PatientService {
    
    private final PatientsRepository patientsRepository;

    public PatientService(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    public PatientsModel getPatientById(Long id) {
        // Use the patientsRepository to retrieve the patient by ID
        Optional<PatientsModel> patientOptional = patientsRepository.findById(id);
        // Check if the patient was found
        if (patientOptional.isPresent()) {
            return patientOptional.get(); // Return the patient if found
        } else {
            return null; // Return null or handle the case where the patient is not found
        }
    }

    public void savePatient(PatientsModel patientsModel) {
        Optional<PatientsModel> patientOptional = Optional.of(patientsRepository.save(patientsModel));
        System.out.println("Diagnosis updated: " + patientOptional);

    }
}
