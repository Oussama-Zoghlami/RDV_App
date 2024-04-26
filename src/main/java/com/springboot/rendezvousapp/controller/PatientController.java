package com.springboot.rendezvousapp.controller;

import com.springboot.rendezvousapp.entities.ModePaiement;
import com.springboot.rendezvousapp.entities.Patient;
import com.springboot.rendezvousapp.services.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final Services patientServices;
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hi Patient");
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/addpatient")
    public Patient addPatient(@RequestBody Patient patient) {
        Patient p=patientServices.addPatient(patient);
        return p;
    }



}
