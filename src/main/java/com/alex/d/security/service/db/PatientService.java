package com.alex.d.security.service.db;

import com.alex.d.security.models.PatientsModel;
import com.alex.d.security.repositories.PatientsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PatientService {
    
    private final PatientsRepository patientsRepository;

    public PatientService(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    public PatientsModel getDataById(Long id) {
        Optional<PatientsModel> patientOptional = patientsRepository.findById(id);
        return patientOptional.orElse(null);
    }

    public void saveData(PatientsModel patientsModel) {
        Optional<PatientsModel> patientOptional = Optional.of(patientsRepository.save(patientsModel));
        System.out.println("Diagnosis updated: " + patientOptional);

    }
}
