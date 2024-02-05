package com.alex.d.security.controller.data;

import com.alex.d.security.entity.db.PatientsModel;
import com.alex.d.security.repositories.db.PatientsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class DeleteDataController {

   private final PatientsRepository patientsRepository;

    public DeleteDataController(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }


    @GetMapping("/delete-patient/{id}")
    public String deletePatient(@PathVariable Long id) {
        // Check if the patient exists
//        Optional<PatientsModel> patientOptional = patientsRepository.findById(id)
        Optional<PatientsModel> patientOptional = patientsRepository.findById(id);
        if (patientOptional.isPresent()) {
            patientsRepository.deleteById(id);
        }
        // Redirect back to the patient list
        return "redirect:/list";
    }
}
