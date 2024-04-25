package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.Patient;
import com.springboot.rendezvousapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {

    Optional<Patient> findById(Integer idPatient);
    Patient findByNomPatient(String nomDuPatient);
}
