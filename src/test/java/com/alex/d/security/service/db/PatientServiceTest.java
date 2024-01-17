//package com.alex.d.security.service.db;
//
//import com.alex.d.security.models.db.PatientsModel;
//import com.alex.d.security.repositories.db.PatientsRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.beans.Transient;
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class PatientServiceTest {
//
//    @InjectMocks
//    private PatientService patientService;
//
//    @Mock
//    private PatientsRepository patientsRepository;
//
//    public PatientServiceTest() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void getDataById() {
//        // Создайте тестового пациента
//        PatientsModel patient = new PatientsModel();
//        patient.setId(100L);
//        patient.setFirst_name("John");
//        patient.setLast_name("Doe");
//        patient.setDiagnosis("Test diagnosis");
//
//
//        // Укажите, что должен возвращать репозиторий при вызове findById
//        when(patientsRepository.findById(100L)).thenReturn(Optional.of(patient));
//
//        // Вызовите метод, который вы хотите протестировать
//        PatientsModel result = patientService.getDataById(100L);
//
//        // Проверьте, что результат соответствует ожиданиям
//        assertEquals("John", result.getFirst_name());
//        assertEquals("Doe", result.getLast_name());
//        assertEquals("Test diagnosis", result.getDiagnosis());
//    }
//
//    @Transient
//    @Test
//    void saveData() {
//        // Создайте тестового пациента
//        PatientsModel patient = new PatientsModel();
//        patient.setFirst_name("Alice");
//        patient.setLast_name("Smith");
//        patient.setDiagnosis("Another diagnosis");
//
//        // Укажите, что должен возвращать репозиторий при сохранении
//        when(patientsRepository.save(patient)).thenReturn(patient);
//
//        // Вызовите метод, который вы хотите протестировать
//        PatientsModel savedPatient = patientService.saveData(patient);
//
//        // Проверьте, что сохраненный пациент соответствует входным данным
//        assertEquals("Alice", savedPatient.getFirst_name());
//        assertEquals("Smith", savedPatient.getLast_name());
//        assertEquals("Another diagnosis", savedPatient.getDiagnosis());
//
//        // Проверьте, что метод save был вызван один раз
//        verify(patientsRepository, times(1)).save(patient);
//    }
//}
