package com.alex.d.security.controller.data;

import com.alex.d.security.entity.db.PatientsModel;
import com.alex.d.security.service.db.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateDataController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UpdateDataController.class);
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
