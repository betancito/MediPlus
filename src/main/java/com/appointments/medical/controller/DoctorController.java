package com.appointments.medical.controller;

import com.appointments.medical.model.entity.Doctor;
import com.appointments.medical.model.entity.Patient;
import com.appointments.medical.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/create")
    @Operation(description = "doctor Creation Endpoint")
    @ApiResponse(responseCode = "201", description = "doctor created successfully")
    @ApiResponse(responseCode = "400", description = "Unable to create doctor")
    public Doctor createPatient(Doctor doctor){
        return doctorService.create(doctor);
    }

    @GetMapping("/id/{id}")
    @Operation(description = "Get doctor by id endpoint")
    @ApiResponse(responseCode = "200",description = "doctor found")
    @ApiResponse(responseCode = "404", description = "doctor not found")
    public Doctor findbyid(@PathVariable("id") Long id){
        return doctorService.findByid(id);
    }

    @GetMapping("/{identification}")
    @Operation(description = "Get doctor by identification endpoint")
    @ApiResponse(responseCode = "200",description = "doctor found")
    @ApiResponse(responseCode = "404", description = "doctor not found")
    public Doctor findbyidentification(@PathVariable("identification") Long identification){
        return doctorService.findByidentification(identification);
    }

    @PutMapping("/{id}")
    @Operation(description = "Get doctor by id endpoint")
    @ApiResponse(responseCode = "200",description = "doctor updated")
    @ApiResponse(responseCode = "404", description = "doctor not found")
    public Doctor update(@PathVariable Long id, Doctor doctor){
        return doctorService.update(id, doctor);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "delete doctor by id endpoint")
    @ApiResponse(responseCode = "200",description = "doctor deleted")
    @ApiResponse(responseCode = "404", description = "doctor not found")
    public void delete(@PathVariable Long id){
        doctorService.delete(id);
    }

    @PutMapping("/available/{id}")
    @Operation(description = "update doctor availability by identification endpoint")
    @ApiResponse(responseCode = "200",description = "doctor updated")
    @ApiResponse(responseCode = "404", description = "doctor not found")
    public String update(@PathVariable Long id, Boolean available){
        return doctorService.setAvailable(id, available);
    }


    @PutMapping("/shift/{id}")
    @Operation(description = "update doctor availability by identification endpoint")
    @ApiResponse(responseCode = "200",description = "doctor updated")
    @ApiResponse(responseCode = "404", description = "doctor not found")
    public Doctor update(@PathVariable Long id, @Parameter  Time shift_start, @Parameter Time shift_end){
        return doctorService.setShift(id, shift_start, shift_end);
    }
}
