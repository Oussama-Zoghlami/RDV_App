package com.springboot.rendezvousapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/medecin")
@RequiredArgsConstructor
public class MedecinController {
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hi Medecin");
    }
}
