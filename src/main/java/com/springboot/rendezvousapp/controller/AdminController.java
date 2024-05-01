package com.springboot.rendezvousapp.controller;

import com.springboot.rendezvousapp.entities.*;
import com.springboot.rendezvousapp.services.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Medecin m=services.addMedecin(medecin);
        return m;
    }




    @PreAuthorize("permitAll()")
    @DeleteMapping("/deleteMedecin/{idMedecin}")
    public void deleteMedecin(@PathVariable ("idMedecin")Integer idMedecin) {
        services.deleteMedecin(idMedecin);
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/addpatient")
    public Patient addPatient(@RequestBody Patient patient) {
        Patient p=services.addPatient(patient);
        return p;
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/updatePatient")
    public Patient updatePatient(@RequestBody  Patient patient) {
        Patient p=services.updatePatient(patient);
        return p;
    }
    @PreAuthorize("permitAll()")
    @DeleteMapping("/deletePatient/{idPatient}")
    public void deletePatient(@PathVariable ("idPatient")Integer idPatient) {
        services.deletePatient(idPatient);
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/affichPatient/{idPatient}")
    public Patient affichPatient(@PathVariable ("idPatient")Integer idPatient) {
        Patient p=services.affichPatient(idPatient);
        return p;
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/listMedecins")
    public List<Medecin> getAllMedecins() {
        List<Medecin> medecins=services.getAllMedecins();
        return medecins;
    }
    @PreAuthorize("permitAll()")
    @PostMapping("/addrdv")
    public RDV ajouterRDV(@RequestBody RDV rdv) {
        RDV rendezvous=services.addRDV(rdv);
        return rendezvous;
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/rdvs/{idRDV}/etat/{etat}")
    public ResponseEntity<?> marquerEtatRDV(@PathVariable("idRDV") Integer idRDV,
                                            @PathVariable("etat") EtatRDV etat,
                                            @RequestParam Integer cinMedecin) {
        services.marquerEtatRDV(idRDV, etat, cinMedecin);
        return ResponseEntity.ok().build();
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/patients/{cinPatient}/rdvs")
    public List<RDV> getRDVsForPatient(@PathVariable Integer cinPatient) {
        return services.getRDVsForPatient(cinPatient);
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/medecin/{cinMedecin}/rdvs")
    public List<RDV> getRDVsForMedecin(@PathVariable Integer cinMedecin) {
        return services.getRDVsForMedecin(cinMedecin);
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/{cin}/mode-paiement")
    public ResponseEntity<String> choisirModePaiement(@PathVariable("cin") Integer cinPatient, @RequestParam ModePaiement modePaiementChoisi) {
        services.choisirModePaiement(cinPatient, modePaiementChoisi);
        return ResponseEntity.status(HttpStatus.OK).body("Mode de paiement choisi avec succès pour le patient avec le CIN : " + cinPatient);
    }
    @PreAuthorize("permitAll()")

    @GetMapping("/byspecialite")
    public List<Medecin> getAllMedecin(@RequestParam Specialite specialite) {
        return services.getAllMedecin(specialite);
    }



    @PreAuthorize("permitAll()")
    @PostMapping("/addclinique")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        Clinique c=services.addClinique(clinique);
        return c;
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/updateClinique")
    public Clinique updateClinique(@RequestBody  Clinique clinique) {
        Clinique c=services.updateClinique(clinique);
        return c;
    }
    @PreAuthorize("permitAll()")
    @DeleteMapping("/deleteClinique/{codeClinique}")
    public void deleteClinique(@PathVariable ("codeClinique")Integer codeClinique) {
        services.deleteClinique(codeClinique);
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/affichClinique/{codeClinique}")
    public Clinique affichClinique(@PathVariable ("codeClinique")Integer codeClinique) {
        Clinique c=services.affichClinique(codeClinique);
        return c;
    }

    @PreAuthorize("permitAll()")

    @GetMapping("/findRDVCommun")
    public ResponseEntity<RDV> findRDVCommun(
            @RequestParam("cinPatient") Integer cinPatient,
            @RequestParam("cinMedecin") Integer cinMedecin
    ) {
        Optional<RDV> rdvCommun = services.findRDVCommun(cinPatient, cinMedecin);
        if (rdvCommun.isPresent()) {
            return ResponseEntity.ok(rdvCommun.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PreAuthorize("permitAll()")
    @PutMapping("/affecterMedecinClinique/{idMed}/{idClinique}")
    public void affectMedecinClinique (@PathVariable Integer idMed,@PathVariable Integer idClinique){
        services.affectMedecinClinique(idMed,idClinique);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/listRDVs")
    public List<RDV> getAllRDVs() {
        List<RDV> rdvs=services.getAllRDVs();
        return rdvs;
    }


    @PreAuthorize("permitAll()")
    @PutMapping("/updateMedecin")
    public Medecin updateMedecin(@RequestBody  Medecin medecin) {
        Medecin m=services.updateMedecin(medecin);
        return m;
    }








}
