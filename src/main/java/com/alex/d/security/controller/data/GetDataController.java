package com.alex.d.security.controller.data;

import com.alex.d.security.entity.db.PatientsModel;
import com.alex.d.security.repositories.db.PatientsRepository;
import com.alex.d.security.service.db.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GetDataController {
   private final PatientsRepository patientsRepository;
   private final PatientService patientService;

    public GetDataController(PatientsRepository patientsRepository, PatientService patientService) {
        this.patientsRepository = patientsRepository;
        this.patientService = patientService;
    }


    @GetMapping("/list")
    public String getAllData(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "id") String sort,
            Model model) {

        Page<PatientsModel> pages = patientsRepository.findAll(
                PageRequest.of(page, size, Sort.by(sort))
        );
        model.addAttribute("list", pages);

        return "patients/list";
    }

    @GetMapping("/patient/{id}")
    public String getPatientById(@PathVariable Long id, Model model) {
        // Retrieve the patient by ID from your service
        PatientsModel patient = patientService.getDataById(id);
        // Add the patient object to the model for rendering in the template
        model.addAttribute("patient", patient);
        return "patients/view"; // This is the name of your Thymeleaf template
    }
}
