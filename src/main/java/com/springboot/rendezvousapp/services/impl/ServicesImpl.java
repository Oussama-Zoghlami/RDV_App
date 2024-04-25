package com.springboot.rendezvousapp.services.impl;


import com.springboot.rendezvousapp.entities.Medecin;
import com.springboot.rendezvousapp.entities.Patient;
import com.springboot.rendezvousapp.entities.Specialite;
import com.springboot.rendezvousapp.entities.User;
import com.springboot.rendezvousapp.repository.MedecinRepo;
import com.springboot.rendezvousapp.repository.PatientRepo;
import com.springboot.rendezvousapp.repository.UserRepo;
import com.springboot.rendezvousapp.services.Services;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesImpl implements Services {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MedecinRepo medecinRepo;
    @Autowired
    private PatientRepo patientRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }
    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }
    @Override
    public void deleteUser(Integer idUser) {
        userRepo.deleteById(idUser);
    }
    @Override
    public User affichUser(Integer idUser) {
        return userRepo.findById(idUser).orElse(null);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    @Override
    public Medecin addMedecin(Medecin medecin) {
        return medecinRepo.save(medecin);
    }

    @Override
    public void deleteMedecin(Integer idMedecin) {
        medecinRepo.deleteById(idMedecin);
    }

    @Override
    public List<Medecin> getMedecinBySpecialite(Specialite specialite) {
        return medecinRepo.findBySpecialite(specialite);
    }



    @Override
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }
    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepo.save(patient);
    }
    @Override
    public void deletePatient(Integer idPatient) {
        patientRepo.deleteById(idPatient);
    }
    @Override
    public Patient affichPatient(Integer idPatient) {
        return patientRepo.findById(idPatient).orElse(null);
    }











}
