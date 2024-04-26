package com.springboot.rendezvousapp.controller;

import com.springboot.rendezvousapp.entities.EtatRDV;
import com.springboot.rendezvousapp.services.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medecin")
@RequiredArgsConstructor
public class MedecinController {

    private final Services medecinServices;
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hi Medecin");
    }


}
