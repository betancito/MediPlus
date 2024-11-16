package com.appointments.medical.service;


import com.appointments.medical.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;



}
