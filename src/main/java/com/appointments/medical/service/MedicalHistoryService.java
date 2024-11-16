package com.appointments.medical.service;

import com.appointments.medical.model.entity.MedicalHistory;
import com.appointments.medical.model.entity.Patient;
import com.appointments.medical.repository.MedicalHistoryRepository;
import com.appointments.medical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.System.in;

@Service
public class MedicalHistoryService {
    @Autowired
    MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    PatientRepository patientRepository;

    public MedicalHistory create (MedicalHistory medicalHistory){
        return medicalHistoryRepository.save(medicalHistory);
    }

    public void delete (Long id){
        medicalHistoryRepository.deleteById(id);
    }

    public MedicalHistory findByUserid (Long id){
        List<MedicalHistory> medicalHistoryList = medicalHistoryRepository.findAll();
        for (int i = 0; i < medicalHistoryList.size() ; i++) {
            MedicalHistory medicalHistory = medicalHistoryList.get(i);
            Patient userid = medicalHistory.getPatient();
            if (userid.getId()==id){
                return medicalHistory;
            }
        }
        return null;
    }
}
