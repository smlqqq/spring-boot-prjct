package com.alex.d.security.controller.data;

import com.alex.d.security.service.db.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import com.alex.d.security.models.db.PatientsModel;
import com.alex.d.security.repositories.db.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public final class PatientsController {
    //MVC
    //REST
    private final PatientService patientService;
    private final PatientsRepository patientsRepository;

    @Autowired
    public PatientsController(PatientsRepository patientsRepository, PatientService patientService) {
        this.patientsRepository = patientsRepository;
        this.patientService = patientService;
    }

    @GetMapping("/registration")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new PatientsModel());
        return "patients/registration";
    }

    @PostMapping("/registration")
    public String submitAddPatientForm(
            @ModelAttribute("patient") PatientsModel patient,
            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "err/error";
        }
        PatientsModel savedPatient = patientsRepository.save(patient);
        model.addAttribute("id", savedPatient.getId());
        return "redirect:/list";
    }

 /*   @GetMapping("/patientsList")
    public String listPatients(Model model) {
//        List<PatientsModel> patients = patientsRepository.findAll();
        List<PatientsModel> patients = patientsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("patientsList", patients);
        return "patients/patientsList";
    }
*/

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

    @GetMapping("/patient/{id}")
    public String getPatientById(@PathVariable Long id, Model model) {
        // Retrieve the patient by ID from your service
        PatientsModel patient = patientService.getDataById(id);
        // Add the patient object to the model for rendering in the template
        model.addAttribute("patient", patient);
        return "patients/view"; // This is the name of your Thymeleaf template
    }

    @PostMapping("/update-diagnosis/{id}")
    public String updateDiagnosis(@PathVariable Long id, @RequestParam("diagnosis") String newDiagnosis) {
        // Logic to update the patient's diagnosis in the database
        // Use the id and newDiagnosis values to perform the update
        PatientsModel patientsModel = patientService.getDataById(id);
        patientsModel.setDiagnosis(newDiagnosis);
        patientService.saveData(patientsModel);
        // Redirect to the patient details page
        return "redirect:/patient/" + id;
    }

    /* Pagination output all data and sort by id */
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

//    private int pageSize = 10;
//    @GetMapping("/list")
//    public  String getAllData(PatientsModel patientsModel, Model model){
//        Pageable pageable = PageRequest.of(0, pageSize);
//        model.addAttribute("list",
//                patientsRepository.findAll(pageable));
//        return "patients/list";
//    }
}

