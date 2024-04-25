package com.springboot.rendezvousapp.services;

import com.springboot.rendezvousapp.entities.Medecin;
import com.springboot.rendezvousapp.entities.Patient;
import com.springboot.rendezvousapp.entities.Specialite;
import com.springboot.rendezvousapp.entities.User;

import java.util.List;

public interface Services {

    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(Integer idUser);
    public User affichUser(Integer idUser);
    public List<User> getAllUsers();

    //Enregistrer les medecins
    public Medecin addMedecin(Medecin medecin);

    public void deleteMedecin(Integer idMedecin);
    //public Medecin affichMedecin(Integer cinMed);
    public List<Medecin> getMedecinBySpecialite(Specialite specialite);
    public Patient addPatient(Patient patient);
    public Patient updatePatient(Patient patient);
    public void deletePatient(Integer idPatient);
    public Patient affichPatient(Integer idPatient);

}
