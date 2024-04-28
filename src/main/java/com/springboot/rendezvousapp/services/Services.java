package com.springboot.rendezvousapp.services;

import com.springboot.rendezvousapp.entities.*;

import java.util.List;
import java.util.Optional;

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

    public Patient addPatient(Patient patient);
    public Patient updatePatient(Patient patient);
    public void deletePatient(Integer idPatient);
    public Patient affichPatient(Integer idPatient);

    //RDV

    public void choisirModePaiement(Integer cinPat, ModePaiement modePaiementChoisi);

    public RDV addRDV(RDV rdv);
    public void marquerEtatRDV(Integer idRDV, EtatRDV nouvelEtat, Integer cinMedecin);
    public List<RDV> getRDVsForPatient(Integer cinPatient);
    public List<RDV> getRDVsForMedecin(Integer cinMedecin);
    List<Medecin> getAllMedecin(Specialite specialite);

    public Clinique addClinique(Clinique clinique);
    public Clinique updateClinique(Clinique clinique);
    public void deleteClinique(Integer codeClinique);
    public Clinique affichClinique(Integer codeClinique);
    public Optional<RDV> findRDVCommun(Integer cinPatient, Integer cinMedecin);



}
