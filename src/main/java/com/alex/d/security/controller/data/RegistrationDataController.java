//package com.alex.d.security.controller.data;
//
//import com.alex.d.security.models.db.PatientsModel;
//import com.alex.d.security.repositories.db.PatientsRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class RegistrationDataController {
//   PatientsRepository patientsRepository;
//
//
//
//    @GetMapping("/registration")
//    public String showAddPatientForm(Model model) {
//        model.addAttribute("patient", new PatientsModel());
//        return "patients/registration";
//    }
//
//    @PostMapping("/registration")
//    public String submitAddPatientForm(
//            @ModelAttribute("patient") PatientsModel patient,
//            BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            return "err/error";
//        }
//        PatientsModel savedPatient = patientsRepository.save(patient);
//        model.addAttribute("id", savedPatient.getId());
//        return "redirect:/list";
//    }
//
//}
