package com.springboot.rendezvousapp.services;

import com.springboot.rendezvousapp.entities.*;

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
    public List<Medecin> getAllMedecins();
    //public Medecin affichMedecin(Integer cinMed);
    public List<Medecin> getMedecinBySpecialite(Specialite specialite);
    public Patient addPatient(Patient patient);
    public Patient updatePatient(Patient patient);
    public void deletePatient(Integer idPatient);
    public Patient affichPatient(Integer idPatient);

    //RDV
    public RDV addRDV(RDV rdv);

}
