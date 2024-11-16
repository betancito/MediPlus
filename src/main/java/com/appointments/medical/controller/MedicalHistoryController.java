package com.appointments.medical.controller;

import com.appointments.medical.model.entity.Doctor;
import com.appointments.medical.model.entity.MedicalHistory;
import com.appointments.medical.service.MedicalHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/medical_history")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping("/{id}")
    @Operation(description = "Endpoint to get Medical history based on patient id")
    @ApiResponse(responseCode = "201", description = "doctor created successfully")
    @ApiResponse(responseCode = "400", description = "Unable to create doctor")
    public MedicalHistory createPatient(Long id){
        return medicalHistoryService.findByUserid(id);
    }
}
