package com.alex.d.security.controller;

import org.springframework.ui.Model;
import com.alex.d.security.models.PatientsModel;
import com.alex.d.security.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
/*
@Controller
public class PatientsController {

    private PatientsRepository patientsRepository;

    @Autowired
    public PatientsController(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    @GetMapping("/patients")
    @ModelAttribute
    public String listPatients(Model model) {
        List<PatientsModel> patientsModels = patientsRepository.findAll();
        model.addAttribute("patients", patientsModels);
        return "patientList"; // Название представления, где будет отображаться список пациентов
    }
}*/

@Controller
public class PatientsController {

    private PatientsRepository patientsRepository;

    @Autowired
    public PatientsController(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
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

    @ModelAttribute
    public void addAttributes(Model model) {
//        model.addAttribute("msg", "Welcome to the Patients System!");
    }

    @GetMapping("/patients")
    public String listPatients(Model model) {
        List<PatientsModel> patients = patientsRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients/patients";
    }

    @GetMapping("/delete-patient/{patientId}")
    public String deletePatient(@PathVariable Long patientId, Model model) {
        // Check if the patient exists
        Optional<PatientsModel> patientOptional = patientsRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            patientsRepository.deleteById(patientId);
        }
        // Redirect back to the patient list
        return "redirect:/patients";
    }

}
/*@Controller
public class PatientsController {

    private final PatientsRepository patientsRepository;

    @Autowired
    public PatientsController(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    @GetMapping("/addPatient")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new PatientsModel());
        return "patients/addPatientForm";
    }

    @PostMapping("/addPatient")
    public String submitAddPatientForm(
            @ModelAttribute("patient") PatientsModel patient) {
        patientsRepository.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients")
    public String listPatients(Model model) {
        List<PatientsModel> patients = patientsRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients/patients";
    }

}*/



/*@Controller
public class PatientsController {

    @Autowired
    private PatientsRepository patientsRepository;

    @GetMapping("/patients")
    public String listPatients(Model model) {
        List<PatientsModel> patients = patientsRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients/patients"; // The name of your Thymeleaf HTML template
//        return "dashboard/user_dash";
    }
}*/
