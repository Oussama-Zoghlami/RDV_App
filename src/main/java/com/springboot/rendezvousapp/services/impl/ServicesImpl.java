package com.springboot.rendezvousapp.services.impl;


import com.springboot.rendezvousapp.entities.Medecin;
import com.springboot.rendezvousapp.entities.User;
import com.springboot.rendezvousapp.repository.MedecinRepo;
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
    public Medecin updateMedecin(Integer cinMedecin, Medecin updatedMedecin) {

        Medecin existingMedecin = medecinRepo.findByCinMedecin(cinMedecin);

        if (existingMedecin != null) {

            existingMedecin.setCinMed(updatedMedecin.getCinMed());
            existingMedecin.setNomMed(updatedMedecin.getNomMed());



            existingMedecin.setTelMed(updatedMedecin.getTelMed());

            existingMedecin.setPrix(updatedMedecin.getPrix());
            // Update other attributes as needed

            // Save the updated medecin
            existingMedecin = medecinRepo.save(existingMedecin);
        } else {
            // Handle the case where the medecin with the given CIN is not found
            throw new EntityNotFoundException("Medecin not found for CIN: " + cinMedecin);
        }

        return existingMedecin;
    }
    @Override
    public void deleteMedecin(Integer idMedecin) {
        medecinRepo.deleteById(idMedecin);
    }

    @Override
    public Medecin affichMedecin(Integer cinMedecin) {
        return medecinRepo.findByCinMedecin(cinMedecin);
    }










}
