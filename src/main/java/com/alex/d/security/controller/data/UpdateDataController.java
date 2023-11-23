package com.alex.d.security.controller.data;

import com.alex.d.security.models.db.PatientsModel;
import com.alex.d.security.service.db.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/data")
public class UpdateDataController {
  private final PatientService patientService;

    public UpdateDataController(PatientService patientService) {
        this.patientService = patientService;
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
}
