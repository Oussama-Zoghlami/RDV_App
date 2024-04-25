package com.springboot.rendezvousapp.controller;

import com.springboot.rendezvousapp.entities.Medecin;
import com.springboot.rendezvousapp.entities.Specialite;
import com.springboot.rendezvousapp.entities.User;
import com.springboot.rendezvousapp.services.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/admin")
@RequiredArgsConstructor
public class AdminController {
    private final Services services;
    //Gerer les utilisateurs

    @PreAuthorize("permitAll()")
    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        User u=services.addUser(user);
        return u;
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody  User user) {
        User u=services.updateUser(user);
        return u;
    }
    @PreAuthorize("permitAll()")
    @DeleteMapping("/deleteUser/{idUser}")
    public void deleteUser(@PathVariable ("idUser")Integer idUser) {
        services.deleteUser(idUser);
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/affichUser/{idUser}")
    public User affichUser(@PathVariable ("idUser")Integer idUser) {
        User u=services.affichUser(idUser);
        return u;
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/listUsers")
    public List<User> getAllUsers() {
        List<User> users=services.getAllUsers();
        return users;
    }
    @PreAuthorize("permitAll()")
    @PostMapping("/addmedecin")
    public Medecin addMedecin(@RequestBody Medecin medecin) {
        Medecin u=services.addMedecin(medecin);
        return u;
    }




    @PreAuthorize("permitAll()")
    @DeleteMapping("/deleteMedecin/{idMedecin}")
    public void deleteMedecin(@PathVariable ("idMedecin")Integer idMedecin) {
        services.deleteMedecin(idMedecin);
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/medecinBySpecialite/{specialite}")
    public List<Medecin> getMedecinBySpecialite(@PathVariable Specialite specialite) {
        return services.getMedecinBySpecialite(specialite);
    }





}
