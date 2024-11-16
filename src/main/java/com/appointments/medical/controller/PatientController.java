package com.appointments.medical.controller;

import com.appointments.medical.model.entity.Patient;
import com.appointments.medical.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/create")
    @Operation(description = "Patient Creation Endpoint")
    @ApiResponse(responseCode = "201", description = "Patient created successfully")
    @ApiResponse(responseCode = "400", description = "Unable to create patient")
    public Patient createPatient(Patient patient){
        return patientService.create(patient);
    }

    @GetMapping("/id/{id}")
    @Operation(description = "Get patient by id endpoint")
    @ApiResponse(responseCode = "200",description = "Patient found")
    @ApiResponse(responseCode = "404", description = "patient not found")
    public Patient findbyid(@PathVariable("id") Long id){
        return patientService.findByid(id);
    }

    @GetMapping("/{identification}")
    @Operation(description = "Get patient by identification endpoint")
    @ApiResponse(responseCode = "200",description = "Patient found")
    @ApiResponse(responseCode = "404", description = "patient not found")
    public Patient findbyidentification(@PathVariable("identification") Long identification){
        return patientService.findByidentification(identification);
    }

    @PutMapping("/{id}")
    @Operation(description = "Get patient by identification endpoint")
    @ApiResponse(responseCode = "200",description = "Patient updated")
    @ApiResponse(responseCode = "404", description = "patient not found")
    public Patient update(@PathVariable Long id, Patient patient){
        return patientService.update(id, patient);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "delete patient by id endpoint")
    @ApiResponse(responseCode = "200",description = "Patient deleted")
    @ApiResponse(responseCode = "404", description = "patient not found")
    public void delete(@PathVariable Long id){
        patientService.delete(id);
    }

}
