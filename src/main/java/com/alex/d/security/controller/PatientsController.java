package com.alex.d.security.controller;

import com.alex.d.security.service.PatientService;
import org.springframework.ui.Model;
import com.alex.d.security.models.PatientsModel;
import com.alex.d.security.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Controller
public class PatientsController {
    private final PatientService patientService;
    private final PatientsRepository patientsRepository;

    @Autowired
    public PatientsController(PatientsRepository patientsRepository, PatientService patientService) {
        this.patientsRepository = patientsRepository;

        this.patientService = patientService;
    }

    @GetMapping("/addPatient")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new PatientsModel());
        return "patients/addPatientForm";
    }

    @PostMapping("/addPatient")
    public String submitAddPatientForm(
            @ModelAttribute("patient") PatientsModel patient,
            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "err/error";
        }
        PatientsModel savedPatient = patientsRepository.save(patient);
        model.addAttribute("id", savedPatient.getId());

//        return "patients/patientView";
        return "redirect:/patients";
    }

    @GetMapping("/patients")
    public String listPatients(Model model) {
        List<PatientsModel> patients = patientsRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients/patients";
    }

    @GetMapping("/delete-patient/{patientId}")
    public String deletePatient(@PathVariable Long patientId) {
        // Check if the patient exists
        Optional<PatientsModel> patientOptional = patientsRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            patientsRepository.deleteById(patientId);
        }
        // Redirect back to the patient list
        return "redirect:/patients";
    }

    @GetMapping("/patient/{id}")
    public String getPatientById(@PathVariable Long id, Model model) {
        // Retrieve the patient by ID from your service
        PatientsModel  patient = patientService.getPatientById(id);
        // Add the patient object to the model for rendering in the template
        model.addAttribute("patient", patient);
        return "patients/patientView"; // This is the name of your Thymeleaf template
    }

    @PostMapping("/update-diagnosis/{id}")
    public String updateDiagnosis(@PathVariable Long id, @RequestParam("diagnosis") String newDiagnosis) {
        // Logic to update the patient's diagnosis in the database
        // Use the id and newDiagnosis values to perform the update
        PatientsModel patientsModel = patientService.getPatientById(id);
        patientsModel.setDiagnosis(newDiagnosis);
        patientService.savePatient(patientsModel);
        // Redirect to the patient details page
        return "redirect:/patient/" + id;
    }
}

