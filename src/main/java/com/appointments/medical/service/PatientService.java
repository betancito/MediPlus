package com.appointments.medical.service;

import com.appointments.medical.model.entity.Patient;
import com.appointments.medical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient findByid(Long id){
        return patientRepository.findById(id).get();
    }

    public Patient findByidentification(Long identification){
        return patientRepository.findByidentification(identification);
    }

    public Patient create(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient update(Long id, Patient patient){

        Patient updatedPatient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        if (updatedPatient!=null) {
            updatedPatient.setFull_name(patient.getFull_name());
            updatedPatient.setIdentification(patient.getIdentification());
            updatedPatient.setEmail(patient.getEmail());
            return patientRepository.save(updatedPatient);
        }
        return null;
    }

    public void delete(Long id){
        patientRepository.deleteById(id);
    }
}
