package com.appointments.medical.service;

import com.appointments.medical.model.entity.Doctor;
import com.appointments.medical.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public Doctor create(Doctor doctor) {
        Doctor doctor1 = new Doctor();
        doctor1.setAvailable(doctor.getAvailable());
        doctor1.setEmail(doctor.getEmail());
        doctor1.setIdentification(doctor.getIdentification());
        doctor1.setFull_name(doctor.getFull_name());
        doctor1.setShift_end(doctor.getShift_end());
        doctor1.setShift_start(doctor.getShift_start());
        return  doctorRepository.save(doctor1);
    }

    public Doctor findByid(Long id) {
        return doctorRepository.getById(id);
    }

    public Doctor findByidentification(Long identification) {
        return doctorRepository.findByidentification(identification);
    }

    public Doctor update(Long id, Doctor doctor) {
        Doctor updatedDoctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        if (updatedDoctor!=null){
            updatedDoctor.setAvailable(doctor.getAvailable());
            updatedDoctor.setEmail(doctor.getEmail());
            updatedDoctor.setIdentification(doctor.getIdentification());
            updatedDoctor.setFull_name(doctor.getFull_name());
            updatedDoctor.setShift_end(doctor.getShift_end());
            updatedDoctor.setShift_start(doctor.getShift_start());
            return doctorRepository.save(updatedDoctor);
        }
        return null;
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    public String setAvailable(Long id, Boolean available){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        if (doctor!=null){
            doctor.setAvailable(available);
            doctorRepository.save(doctor);
            return "Available successfully updated!";
        }
        return "Doctor could not be found";
    }

    public Doctor setShift(Long id, Time shift_start, Time shift_end){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        if (doctor!=null){
            doctor.setShift_start(shift_start);
            doctor.setShift_end(shift_end);
            return doctorRepository.save(doctor);
        }
        else return null;
    }
}
